package br.com.rafael.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GeraExcecaoServlet
 */
@WebServlet(description = "Servlet que gera uma exceção para teste de página de erro", urlPatterns = { "/GeraExcecao" })
public class GeraExcecaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeraExcecaoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		throw new ServletException("Exceção para teste", new Exception("Exceção aninhada"));
	}

}
