package br.com.rafael.test.inicializacaoautomatica;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AutoInit3Servlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		System.out.println("Servlet 3 inicializado junto a aplicação web.");
	}

}
