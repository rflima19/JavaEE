package br.com.rafael.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FiltroAutenticacao implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAutenticacao() {
        super();
    }

    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro de autentica��o iniciado.");
	}
    
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Filtro de autentica��o destruido.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("realizando altentica��o");
		
		HttpServletRequest req = (HttpServletRequest) request;
		String user = req.getParameter("user");
		if ((user == null) || !(user.equals("rafa"))) {
			req.getRequestDispatcher("/negaAcesso.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}
}
