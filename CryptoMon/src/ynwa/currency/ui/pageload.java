package ynwa.currency.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ynwa.currency.entity.*;
import ynwa.currency.source.*;

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
		
		switch (pageIdentity) {
			case "providers":
				IStorageHelper storage = new MySqlHelper();
				List<Provider> providers = storage.SelectProviders();
				String json = new Gson().toJson(providers);
				String[] providerCols = new Provider().GetColumnNames();
				String providerColJson = new Gson().toJson(providerCols);
				jsonObject.addProperty("providers", json);
				jsonObject.addProperty("providerCols", providerColJson);
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
