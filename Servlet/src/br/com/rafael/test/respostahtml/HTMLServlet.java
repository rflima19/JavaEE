package br.com.rafael.test.respostahtml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HTMLServlet
 */
@WebServlet("/HTML")
public class HTMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTMLServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()) {
			
			// primeiro temos de informa ao browser qual tipo de dados estamos retornando
			response.setContentType("text/html");
			
			// agora podemos retorna os dados
			out.print("<!DOCTYPE html>\r\n");
			out.print("<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Dados HTML</title>\r\n" + 
					"</head>\r\n" +
					"<body>\r\n");
			out.print("<h1>Retorno em formato HTML</h1>\r\n");
			out.print("<strong>Texto em negrito</strong>\r\n");
			out.print("</body>\r\n" +
					"</html>");
		}
	}

}
