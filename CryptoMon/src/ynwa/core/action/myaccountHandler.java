package ynwa.core.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynwa.core.data.UserEntity;
import ynwa.core.entity.User;
import ynwa.core.helper.PasswordService;

@WebServlet("/myaccountHandler")
public class myaccountHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public myaccountHandler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserEntity entitySaver = new UserEntity();
		User currentUser = entitySaver.Select(userId); 
		
		if (currentUser != null) {
			currentUser.setLoginName(request.getParameter("loginName"));
			currentUser.setName(request.getParameter("firstName"));
			currentUser.setLastName(request.getParameter("lastName"));
			currentUser.setUpdateDate(new Date());
			
			if (email != null && !email.isEmpty() && !email.equals(currentUser.getEmail())) {
				currentUser.setEmail(email);
				currentUser.setStatus(0); // email not confirmed
			}
			
			if (password != null && !password.isEmpty()) {
				PasswordService pws = new PasswordService();
				String encryptedPass = pws.encrypt(password);
				currentUser.setPassword(encryptedPass);
				session.invalidate();
			}
			
			entitySaver.Update(currentUser);
			request.setAttribute("errorMessage", "");
		} else {
			request.setAttribute("errorMessage", "user not found");
		}
	}

}
