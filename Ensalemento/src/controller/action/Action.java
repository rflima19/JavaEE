package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.service.ServiceFactory;
import model.util.HibernateUtil;

public abstract class Action {

	private HttpServletRequest request;
	private HttpServletResponse response;
	protected ServiceFactory serviceFactory;

	public Action() {
		super();
		this.serviceFactory = ServiceFactory.getInstance();
	}

	public void runAction() throws Exception {
		try {
			HibernateUtil.beginTransaction();
			this.process();
			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			throw e;
		}
	}
	
	public abstract void process() throws Exception;
	
	public void forward(String path) throws Exception {
		this.request.getRequestDispatcher("/" + path).forward(this.request, this.response);
	}
	
	public void redirect(String path) throws Exception {
		String contextRoot = this.request.getContextPath();
		this.response.sendRedirect(contextRoot + "/" + path);
	}

	public HttpSession getHttpSession() {
		return this.request.getSession();
	}
	
	public HttpServletResponse getResponse() {
		return this.response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
}
