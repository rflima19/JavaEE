package br.com.rafael.exercicio2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttrSessionServlet
 */
@WebServlet(name = "createAttr", urlPatterns = { "/AdicionaAtributoSession" })
public class AttrSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttrSessionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");
		
		if ((nome != null) && (valor != null)) {
			request.getSession().setAttribute(nome, valor);
		}
		
		response.sendRedirect("/Filters/form.jsp");
	}

}
