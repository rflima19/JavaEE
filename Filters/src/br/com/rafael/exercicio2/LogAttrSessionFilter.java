package br.com.rafael.exercicio2;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogAttrSessionFilter implements Filter {

	private static int cont = 1;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		chain.doFilter(request, response);
		
		HttpServletRequest res = (HttpServletRequest) request;

		HttpSession session = res.getSession();

		Enumeration<String> attrs = session.getAttributeNames();

		System.out.println("Requisição número " + LogAttrSessionFilter.cont++ + ":");
		System.out.print(String.format("%s%n%n", "Atributos Escopo Session:"));
		System.out.print(String.format("%20s%40s%n", "Nome", "Valor"));
		while (attrs.hasMoreElements()) {
			String nameAttr = attrs.nextElement();
			String valor = (String) session.getAttribute(nameAttr);
			String message = String.format("%20s%40s%n", nameAttr, valor);
			System.out.print(message);
		}
		System.out.println("----------------------------------------------------------------------------");
	}
}
