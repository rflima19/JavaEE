package br.com.rafael.test;

import java.io.IOException;
import java.time.Instant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerificaTempoSessaoServlet
 */
@WebServlet("/Sessao")
public class VerificaTempoSessaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificaTempoSessaoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		long lastAccess = session.getLastAccessedTime();
		long now = Instant.now().toEpochMilli();
		int timeout = session.getMaxInactiveInterval();
		
		
		if ((now - lastAccess) < timeout) {
			request.getRequestDispatcher("/aceitaAcesso.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/negaAcesso.jsp").forward(request, response);
		}
	}

}
