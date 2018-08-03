package ynwa.currency.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Servlet implementation class Runner
 */
@WebServlet("/Runner")
public class Runner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(Runner.class.getName());
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Runner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("test started");
		
		StringBuilder testOutput = new StringBuilder();
		Result result = JUnitCore.runClasses(TestCryptoMon.class);
		
	    for (Failure failure : result.getFailures()) {
	    	testOutput.append("Failure:" + failure.toString()).append("\n");
	    }
		 
	    testOutput.append("Test Result:" + result.wasSuccessful());
	    log.info("test ended");
		response.getWriter().append(testOutput.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
