package br.com.rafael.test;

import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class TimeFilter
 */
@WebFilter(description = "Filtro para verificar duração de tempo da requisição e resposta", urlPatterns = { "/*" })
public class TimeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TimeFilter() {
    	
    }

    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
    
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		long start = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		
		long time = end - start;
		
		try (FileWriter fileLog = new FileWriter("C:/Users/Rafa/Desktop/log.txt", true)) {
			fileLog.write("URI: " + req.getRequestURI() + " : " + time + "ms");
			fileLog.write(System.getProperty("line.separator"));
		}
	}

	

}
