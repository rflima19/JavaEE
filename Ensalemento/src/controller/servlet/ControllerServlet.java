package controller.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Properties actions;
	
	static {
		try (InputStream in = ControllerServlet.class.getResourceAsStream("/action.properties")) {
			ControllerServlet.actions = new Properties();
			ControllerServlet.actions.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		String path = request.getServletPath();
		path = path.substring(1, path.indexOf("."));
		
		String actionClass = ControllerServlet.actions.getProperty(path);
		
		if (actionClass == null) {
			throw new ServletException("A action " + actionClass + " não está mapeada!");
		}
		
		try {
			Action action = (Action) Class.forName(actionClass).getDeclaredConstructor().newInstance();
			action.setRequest(request);
			action.setResponse(response);
			action.runAction();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
