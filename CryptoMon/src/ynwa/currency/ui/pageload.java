package ynwa.currency.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ynwa.core.data.*;
import ynwa.core.entity.*;

@WebServlet("/pageload")
public class pageload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public pageload() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageIdentity = request.getParameter("pageIdentity");
		JsonObject jsonObject = new JsonObject();
		HttpSession session = request.getSession();
		
		switch (pageIdentity) {
			case "myaccount":
				User currentUser = (User) session.getAttribute("user");
				if (currentUser != null) {
					currentUser.setPassword("***");
					String userJson = new Gson().toJson(currentUser);
					jsonObject.addProperty("currentUser", userJson);
				}
				break;
			default:
				break;
		}
		
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonObject.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
