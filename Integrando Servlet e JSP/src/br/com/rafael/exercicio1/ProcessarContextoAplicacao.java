package br.com.rafael.exercicio1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessarContextoAplicacao
 */
@WebServlet(description = "Processa os parametros enviados na request POST e os transforma em atributo do contexto context. Lista os atributos do contexto context quando recebe uma requisição GET", urlPatterns = {
		"/ProcessarContextoAplicacao" })
public class ProcessarContextoAplicacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReentrantReadWriteLock readWriterLock;
	private Lock writer;
	private Lock read;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessarContextoAplicacao() {
		super();
		this.readWriterLock = new ReentrantReadWriteLock();
		this.writer = this.readWriterLock.writeLock();
		this.read = this.readWriterLock.readLock();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtem os paramentros da request
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");

		// obtem o contexto context da aplicação
		ServletContext context = this.getServletContext();

		// set o atributo no contexto context
		this.writer.lock();
		try {
			context.setAttribute(nome, valor);
		} finally {
			this.writer.unlock();
		}

		// redireciona para o servlet que lista os atributos do contexto context
		response.sendRedirect("/integracao/ProcessarContextoAplicacao");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtem o contexto context da aplicação
		ServletContext context = this.getServletContext();

		Map<String, Object> mapAttrs = new LinkedHashMap<>();
		Enumeration<String> atributos = null;
		this.read.lock();
		try {
			// obtem os nomes de todos os atributos do contexto context
			atributos = context.getAttributeNames();

			if (atributos != null) {
				while (atributos.hasMoreElements()) {
					String nameAttr = atributos.nextElement();
					// recupera o valor do atributo do contexto context
					Object attr = context.getAttribute(nameAttr);

					mapAttrs.put(nameAttr, attr);
				}
			}
		} finally {
			this.read.unlock();
		}

		// set atributo no contexto request
		request.setAttribute("map", mapAttrs);

		request.getRequestDispatcher("/listarAtributosContextoAplicacao.jsp").forward(request, response);
	}

}
