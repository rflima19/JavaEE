package br.com.rafael.exercicio1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsereAtributoContextServlet
 */
@WebServlet(description = "Converte os dados da requisição em atributos do escopo context", urlPatterns = { "/addContext" })
public class InsereAtributoContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsereAtributoContextServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String attr = request.getParameter("valor");
		
		if ((nome != null) && (attr != null)) {
			ServletContext context = this.getServletContext();
			context.setAttribute(nome, attr);
		}
		
		response.sendRedirect("/SimplificandoJSP/listaContext.jsp");
		//request.getRequestDispatcher("/listaContext.jsp").forward(request, response);
		
	}

}
