package br.com.rafael.test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SegurancaFilter
 */
@WebFilter("/sec/*")
public class SegurancaFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SegurancaFilter() {
    	
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
		
		HttpSession session = req.getSession();
		
		UserInfo user = (UserInfo) session.getAttribute("userInfo");
		
		if (user == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			
			// envia como resposta o erro 403 do http de acesso negado
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
		} else {
			chain.doFilter(request, response);
		}
	}
}
