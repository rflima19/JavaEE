package br.com.rafael.test.enviamensagemsimples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MensagemServlet2 extends HttpServlet {

	public MensagemServlet2() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try (PrintWriter out = resp.getWriter()) {
			out.println("Mensagem enviada de um Servlet configurado no arquivo web.xml");
		}
	}
}
