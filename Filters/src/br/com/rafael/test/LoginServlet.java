package br.com.rafael.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("user");
		String senha = request.getParameter("password");

		/*
		 * Aqui deveria ser feito o acesso a base de dados para autenticar o usuario e
		 * senha
		 */
		
		if ((usuario != null) && (senha != null)) {
			UserInfo user = new UserInfo();
			user.setNome(usuario);
			user.setSenha(senha);

			request.getSession().setAttribute("userInfo", user);
		}
		
		response.sendRedirect("/Filters/sucesso.jsp");
	}

}
