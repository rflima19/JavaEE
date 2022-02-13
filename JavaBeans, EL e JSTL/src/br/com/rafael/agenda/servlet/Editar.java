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
 * Servlet implementation class Editar
 */
@WebServlet(description = "Edita um contato", urlPatterns = { "/Agenda/Editar" })
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId = request.getParameter("id");
		//Integer id = strId != null ? Integer.valueOf(strId) : null;
		
		//if (id != null) {
		if (strId != null) {
			Integer id = Integer.valueOf(strId);
			Contato contato = Agenda.getIsntance().getContato(id);
			request.setAttribute("contato", contato);
		}
		
		request.getRequestDispatcher("/editarAgenda.jsp").forward(request, response);
	}

}
