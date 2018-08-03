package ynwa.currency.source;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynwa.currency.entity.Provider;

/**
 * Servlet implementation class providerop
 */
@WebServlet("/providerop")
public class providerop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public providerop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IStorageHelper storage = new MySqlHelper();
		try {
			Provider provider = new Provider();
			UUID tranUId = UUID.randomUUID();
	        provider.setId(tranUId.toString());
			provider.setName(request.getParameter("name"));
			provider.setUrl(request.getParameter("url"));
			provider.setReloadTime(Integer.parseInt(request.getParameter("reloadTime")));
			storage.InsertProvider(provider);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.setStatus(HttpURLConnection.HTTP_INTERNAL_ERROR);
		} catch (NumberFormatException e) {
			response.setStatus(HttpURLConnection.HTTP_INTERNAL_ERROR);
			response.getWriter().append("Reload time should be valid integer.");
		} catch (Exception e) {
			response.setStatus(HttpURLConnection.HTTP_INTERNAL_ERROR);
			response.getWriter().append(e.getMessage());
		}
	}

}
