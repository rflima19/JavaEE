package br.com.rafael.agenda.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.agenda.model.Agenda;
import br.com.rafael.agenda.model.Contato;

/**
 * Servlet implementation class Salvar
 */
@WebServlet(description = "Salva os dados do contato depois de uma criação ou edição", urlPatterns = {
		"/Agenda/Salvar" })
public class Salvar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Salvar() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strId = request.getParameter("id");
		String strNome = request.getParameter("nome");
		String strTelefone = request.getParameter("telefone");

		if (strNome != null && strTelefone != null) {
			Contato contato = new Contato();

			if (strId != null) {
				contato.setId(Integer.valueOf(strId));
			}

			contato.setNome(strNome);
			contato.setTelefone(strTelefone);

			Agenda.getIsntance().salvar(contato);
		}

		response.sendRedirect("/SimplificandoJSP/Agenda/Listar");
	}

}
