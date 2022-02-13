package br.com.rafael.exercicio2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessarFormEmail
 */
@WebServlet(description = "Processa requisição do formulario de nome", urlPatterns = { "/ProcessarFormNome" })
public class ProcessarFormNome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessarFormNome() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String nome = request.getParameter("nome");

		session.setAttribute("nome", nome);

		response.sendRedirect("/integracao/formTelefone.jsp");
	}

}
