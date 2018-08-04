package ynwa.core.action;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynwa.core.data.UserEntity;
import ynwa.core.entity.User;

@WebServlet("/registerHandler")
public class registerHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public registerHandler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UUID tranUId = UUID.randomUUID();
		
		User user = new User();
		user.setLoginName(request.getParameter("loginName"));
		user.setEmail(request.getParameter("email"));
		user.setEntryDate(new Date());
		user.setLastLoginDate(new Date());
		user.setPassword(request.getParameter("password"));
		user.setStatus(0); // email not confirmed
		user.setUpdateDate(new Date());
		user.setUserId(tranUId.toString());
		user.setName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		
		UserEntity entitySaver = new UserEntity();
		entitySaver.Insert(user);
	}

}
