package ynwa.core.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;

import javax.el.MethodNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import ynwa.core.helper.CoreHelper;

@WebServlet("/formHandler")
public class formHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(formHandler.class.getName());
    
    public formHandler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action =	request.getParameter("action");
			if (action != null && !action.isEmpty()) {
				log.debug("Action started:" + action);
				InvokeHandlerMethod(action, request, response);
				log.debug("Action finished:" + action);
			} else {
				throw new Exception("action is empty");
			}
			
			String errorMessage = (String) request.getAttribute("errorMessage");
			if (errorMessage != null && !errorMessage.isEmpty()) {
				response.setStatus(HttpURLConnection.HTTP_INTERNAL_ERROR);
				response.getWriter().append(errorMessage);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error(CoreHelper.GetStackTrace(e));
			response.setStatus(HttpURLConnection.HTTP_INTERNAL_ERROR);
			response.getWriter().append(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void InvokeHandlerMethod(String handlerName, HttpServletRequest request, HttpServletResponse response) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		Object handler = GetHandler(handlerName);
		if (handler != null) {
			Class[] cArg = new Class[2];
	        cArg[0] = HttpServletRequest.class;
	        cArg[1] = HttpServletResponse.class;
	        
			Method handlerMethod = handler.getClass().getMethod("doPost", cArg);
			
			if (handlerMethod != null) {
				handlerMethod.invoke(handler, request, response);
			} else {
				throw new MethodNotFoundException("doPost");
			}
		} else {
			throw new ClassNotFoundException(handlerName);
		}
	}
	
	protected Object GetHandler(String handlerName) {
    	String packageName = "ynwa.core.action." + handlerName;
        Class<?> testClass;
        Object testObject = null;
		try {
			testClass = Class.forName(packageName);
			testObject = testClass.newInstance();
			return testObject;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
    }
}
