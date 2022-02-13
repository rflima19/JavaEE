package br.com.rafael.test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(description = "Filtro para criptografia da resposta aos clientes", 
	servletNames = { "servlet2" }
)
public class FiltroCriptografia implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroCriptografia() {
        super();
    }

    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro de criptografia iniciado.");
	}
    
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Filtro de criptografia destruido.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);
		
		System.out.println("realizando criptografia");
	}
}
