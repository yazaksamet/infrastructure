package ynwa.core.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynwa.core.data.MLManager;
import ynwa.core.entity.MLString;

@WebServlet("/mlstringHandler")
public class mlstringHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public mlstringHandler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MLString newString = new MLString();
		newString.setKey(request.getParameter("mlKey"));
		newString.setLanguage(request.getParameter("mlLang"));
		newString.setValue(request.getParameter("mlVal"));
		
		MLManager stringManager = new MLManager();
		stringManager.Insert(newString);
	}

}
