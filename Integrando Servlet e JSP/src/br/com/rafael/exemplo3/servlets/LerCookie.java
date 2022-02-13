package br.com.rafael.exemplo3.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LerCookie
 */
@WebServlet("/processarCookie")
public class LerCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LerCookie() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ler parametro passado na requisicão
		String nome = request.getParameter("nome");
		
		// cria um novo cookie
		Cookie c = new Cookie("nomeUser", nome);
		
		// define o tempo de vida do cookie
		c.setMaxAge(60);
		
		// adiciona o cookie a resposta ao cliente
		response.addCookie(c);
		
	}

}
