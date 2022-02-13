package br.com.rafael.test.sessoes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LendoDadosSessao
 */
@WebServlet("/sessao")
public class LendoDadosSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendoDadosSessao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		if (session != null) {
			System.out.println("ID da sessão: " + session.getId());
			System.out.println("Último acesso: " + new Date(session.getLastAccessedTime()));
			System.out.println("Tempo máximo da sessão aberta em inatividade: " + session.getMaxInactiveInterval() + " segundos");
		}
	}

}
