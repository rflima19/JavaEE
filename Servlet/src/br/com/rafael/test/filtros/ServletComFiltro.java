package br.com.rafael.test.filtros;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletComFiltro
 */
@WebServlet("/filtroTest")
public class ServletComFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletComFiltro() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			response.setContentType("text/html");

			// agora podemos retorna os dados
			out.print("<!DOCTYPE html>\r\n");
			out.print("<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Teste de Filtro</title>\r\n" + "</head>\r\n" + "<body>\r\n");
			out.print("<p>Respondido.</p>\r\n");
			out.print("</body>\r\n" + "</html>");
		}
	}

}
