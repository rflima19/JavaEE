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
 * Servlet implementation class AdicionarProduto
 */
@WebServlet(description = "Adiciona um produto ao carrinho de compras", urlPatterns = { "/adicionar" })
public class AdicionarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionarProduto() {
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

//		// verifica se é o primeiro acesso do cliente
//		if (session.isNew()) {
//			// cria o carrinho do cliente
//			CarrinhoCompras c = new CarrinhoCompras();
//			// adiciona o carrinho como atributo no escopo session
//			session.setAttribute("carrinho", c);
//		}

		// recupera o atributo do escopo session
		CarrinhoCompras carrinho = (CarrinhoCompras) session.getAttribute("carrinho");

		// verifica se é o primeiro acesso do cliente
		if (carrinho == null) {
			// cria o carrinho do cliente
			carrinho = new CarrinhoCompras();
			// adiciona o carrinho como atributo no escopo session
			session.setAttribute("carrinho", carrinho);
		}

		// adiciona o novo produto ao carrinho de compras
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		Produto p = Produto.getProdutoById(id);
		carrinho.add(p);
		
		// redireciona para o servlet que lista os produtos
		response.sendRedirect("/integracao/produtos");
	}

}
