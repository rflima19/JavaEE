package br.com.rafael.test.parametroscontexto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lerParametrosContexto" })
public class LendoParametrosContexto extends HttpServlet {

	public LendoParametrosContexto() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// lendo parametros de contexto
		ServletContext context = this.getServletContext();
		String p1 = context.getInitParameter("banco");
		String p2 = context.getInitParameter("senha");
		
		System.out.println("Banco de dados: " + p1);
		System.out.println("Senha: " + p2);

		try (PrintWriter out = response.getWriter()) {
			response.setContentType("text/html");

			// agora podemos retorna os dados
			out.print("<!DOCTYPE html>\r\n");
			out.print("<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Parametros</title>\r\n" + "</head>\r\n" + "<body>\r\n");
			out.print("<p>Parametros de contextos lidos</p>\r\n");
			out.print("</body>\r\n" + "</html>");
		}
	}
}
