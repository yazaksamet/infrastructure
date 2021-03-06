package ynwa.core.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynwa.core.data.UserManager;
import ynwa.core.entity.*;
import ynwa.core.helper.PasswordService;

@WebServlet("/loginHandler")
public class loginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session; 
	private int loginAttempts;
	private int legalLoginAttemp = 5;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginHandler() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//User has clicked the logout link
		session = request.getSession();

		//check to make sure we've clicked link
		if(request.getParameter("logout") != null){
			logout();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get our current session
		session = request.getSession();

		//get the number of logins
		if(session.getAttribute("loginAttempts") == null){
			loginAttempts = 0;
		} else {
			loginAttempts = (int) session.getAttribute("loginAttempts");
		}
		
		//exceeded logins
		if(loginAttempts > legalLoginAttemp){
			String errorMessage = "Error: Number of Login Attempts Exceeded";
			request.setAttribute("errorMessage", errorMessage);
		}else{	//proceed
			//pull the fields from the form
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");

			//encrypt the password to check against what's stored in DB
			PasswordService pws = new PasswordService();
			String encryptedPass = pws.encrypt(password);
			
			//create a user helper class to make database calls, and call authenticate user method
			UserManager userStorage = new UserManager();
			User user = userStorage.GetUserWithPassword(loginName, encryptedPass);

			//we've found a user that matches the credentials
			if(user != null){
				//invalidate current session, then get new session for our user (combats: session hijacking)
				session.invalidate();
				session=request.getSession(true);
				session.setAttribute("user", user);
				user.setLastLoginDate(new Date());
				userStorage.Update(user);
			}
			// user doesn't exist, redirect to previous page and show error
			else{
				String errorMessage = "Error: Unrecognized Username or Password<br>Login attempts remaining: "+(legalLoginAttemp -(loginAttempts));
				request.setAttribute("errorMessage", errorMessage);

				//track login attempts (combats: brute force attacks)
				session.setAttribute("loginAttempts", ++loginAttempts);
			}
		}
	}
	
	public void logout() {
		session.invalidate();
	}
}
