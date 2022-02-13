package br.com.rafael.exercicio2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessarCadastroServlet
 */
@WebServlet(description = "Processa o cadrastro dos dados do cliente dividido entre varias telas", urlPatterns = { "/ProcessarCadastroServlet" })
public class ProcessarCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessarCadastroServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tela = request.getParameter("tela");
		String proximaTela = null;
		HttpSession session = request.getSession();
		
		if (tela.equals("email")) {
			String email = request.getParameter("email");
			session.setAttribute("email", email);
			proximaTela = "/formNome.jsp";
		} else if (tela.equals("nome")) {
			String email = request.getParameter("nome");
			session.setAttribute("nome", email);
			proximaTela = "/formTelefone.jsp";
		} else if (tela.equals("telefone")) {
			String email = request.getParameter("telefone");
			session.setAttribute("telefone", email);
			proximaTela = "/SimplificandoJSP/listaCadastro.jsp";
			response.sendRedirect(proximaTela);
			return;
		}
		
		request.getRequestDispatcher(proximaTela).forward(request, response);
	}

}
