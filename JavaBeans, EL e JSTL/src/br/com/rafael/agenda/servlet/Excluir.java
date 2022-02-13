package br.com.rafael.agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.agenda.model.Agenda;

/**
 * Servlet implementation class Excluir
 */
@WebServlet(description = "Exclui um contato", urlPatterns = { "/Agenda/Excluir" })
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Excluir() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");

		Agenda.getIsntance().remover(Integer.valueOf(strId));
		
		response.sendRedirect("/SimplificandoJSP/Agenda/Listar");
	}

}
