package br.com.rafael.test.cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LendoCookies
 */
@WebServlet("/lendoCookies")
public class LendoCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LendoCookies() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				int tempoDeVida = cookie.getMaxAge();
				String nome = cookie.getName();
				String valor = cookie.getValue();
				System.out.println("Cookie " + nome + " com valor " + valor + " com tempo de vida " + tempoDeVida);
			}
		} else {
			System.out.println("Sem Cookies");
		}
	}
}
