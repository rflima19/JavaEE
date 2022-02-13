package br.com.rafael.test;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
    	
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("Request Destruida");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  {
    	HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
    	String URI = request.getRequestURI();
    	request.setAttribute("user", "1234");
        System.out.println(URI + " : Request Inicializada");
    }
	
}
