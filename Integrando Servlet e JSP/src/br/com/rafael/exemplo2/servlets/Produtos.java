package br.com.rafael.exemplo2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.rafael.exemplo2.model.CarrinhoCompras;
import br.com.rafael.exemplo2.model.Produto;

/**
 * Servlet implementation class Produtos
 */
@WebServlet(description = "Lista os produtos do sistema", urlPatterns = { "/produtos" })
public class Produtos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Produtos() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// set o atributo no escopo request
		request.setAttribute("lista", Produto.getProdutos());

		// redireciona (encaminha) a requisição para o JSP
		request.getRequestDispatcher("/listarProdutos.jsp").forward(request, response);
	}

}
