package br.com.rafael.exemplo1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.exemplo1.model.Properties;

/**
 * Servlet implementation class DeletarProps
 */
@WebServlet(description = "Excluir uma propriedade", urlPatterns = { "/deletar" })
public class DeletarProps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarProps() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// obtem o parametro passado na requisição
		String idProp = request.getParameter("prop");
		
		Properties.delete(idProp);
		
		// redireciona para o o servlet listar
		response.sendRedirect("/integracao/listar");
	}

}
