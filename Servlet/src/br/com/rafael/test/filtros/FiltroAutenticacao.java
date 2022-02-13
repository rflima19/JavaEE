package br.com.rafael.test.filtros;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FiltroAutenticacao implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAutenticacao() {
        super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Filtro de autenticação destruido.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("realizando altenticação");
		
		String user = request.getParameter("user");
		if ((user == null) || !(user.equals("rafa"))) {
			try (PrintWriter out = response.getWriter()) {
				response.setContentType("text/html");

				// agora podemos retorna os dados
				out.print("<!DOCTYPE html>\r\n");
				out.print("<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Filtro</title>\r\n" + "</head>\r\n" + "<body>\r\n");
				out.print("<p>Seu acesso não foi autoricado.</p>\r\n");
				out.print("</body>\r\n" + "</html>");
			}
			return;
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro de autenticação iniciado.");
	}

}
