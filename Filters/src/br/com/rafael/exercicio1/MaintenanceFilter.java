package br.com.rafael.exercicio1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MaintenanceFilter
 */
public class MaintenanceFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MaintenanceFilter() {
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
		
		Boolean isMaintenance = Boolean.valueOf(ReadProperties.getProperty("maintenance"));
		
		if (isMaintenance) {
			//HttpServletResponse res = (HttpServletResponse) response;
			//res.sendRedirect("/Filters/maintenance.jsp");
			HttpServletRequest req = (HttpServletRequest) request;
			req.getRequestDispatcher("/maintenance.jsp").forward(request, response);
		}  else {
			chain.doFilter(request, response);
		}
	}
}
