package br.com.rafael.agenda.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.agenda.model.Agenda;
import br.com.rafael.agenda.model.Contato;

/**
 * Servlet implementation class Listar
 */
@WebServlet(description = "Lista os contatos", urlPatterns = { "/Agenda/Listar" })
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Set<Contato> contatos = Agenda.getIsntance().getContatos();
		
		request.setAttribute("contatos", contatos);
		
		request.getRequestDispatcher("/listarAgenda.jsp").forward(request, response);
	}

}
