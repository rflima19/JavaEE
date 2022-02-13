package br.com.rafael.test.javabeans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContaServlet
 */
@WebServlet("/ContaServlet2")
public class ContaServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContaServlet2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Conta conta = new Conta();
		conta.setNumero(1234);
		conta.setSaldo(1000.0);
		
		request.setAttribute("conta", conta);
		
		//request.getRequestDispatcher("/alterarConta.jsp").forward(request, response);
		request.getRequestDispatcher("/alterarConta2.jsp").forward(request, response);
	}

}
