package br.com.rafael.exemplo2.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.rafael.exemplo2.model.CarrinhoCompras;
import br.com.rafael.exemplo2.model.Produto;

/**
 * Servlet implementation class Carrinho
 */
@WebServlet(description = "Lista os produtos no carrinho de compras", urlPatterns = { "/carrinho" })
public class Carrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Carrinho() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recupera a sessão do cliente
		HttpSession session = request.getSession();

		// recupera o atributo do escopo session
		CarrinhoCompras carrinho = (CarrinhoCompras) session.getAttribute("carrinho");

		// verifica se é o primeiro acesso do cliente
		if (carrinho == null) {
			// cria o carrinho do cliente
			carrinho = new CarrinhoCompras();
			// adiciona o carrinho como atributo no escopo session
			session.setAttribute("carrinho", carrinho);
		}

		List<Produto> lista = carrinho.getProdutos();

		// set o atributo no escopo request
		request.setAttribute("lista", lista);

		// redireciona (encaminha) a requisição para o JSP
		request.getRequestDispatcher("/listarCarrinho.jsp").forward(request, response);
	}

}
