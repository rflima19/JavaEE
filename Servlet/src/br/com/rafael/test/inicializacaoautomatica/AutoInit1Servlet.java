package br.com.rafael.test.inicializacaoautomatica;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AutoInit2Servlet
 */
public class AutoInit1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String email = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoInit1Servlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("Init 2");
		
		super.init(config);
		
		String email = config.getInitParameter("adminEmail");
		this.email = email;
		
		System.out.println("Servlet carregado, Email do admin = " + this.email);
	}

}
