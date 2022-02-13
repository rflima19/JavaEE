package br.com.rafael.exemplo1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.exemplo1.model.Properties;

/**
 * Servlet implementation class EditarProps
 */
@WebServlet(description = "Editar ou criar uma propriedade", urlPatterns = { "/editar" })
public class EditarProps extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarProps() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idProp = request.getParameter("prop");

		// verifica se será realizada uma edição ou criação de uma propriedade
		if (idProp != null) {
			String valor = Properties.getValue(idProp);

			if (valor != null) {
				// adiciona atributos no escopo request
				request.setAttribute("id", idProp);
				request.setAttribute("valor", valor);
				request.setAttribute("titulo", "Editar");
			}
		}

		// redireciona (encaminha) a requisição para o JSP
		request.getRequestDispatcher("/editarProps.jsp").forward(request, response);
	}

}
