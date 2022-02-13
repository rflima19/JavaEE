package br.com.rafael.exemplo1.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.exemplo1.model.Properties;

/**
 * Servlet implementation class ListarProps
 */
@WebServlet(description = "Listar as propriedades", urlPatterns = { "/listar" })
public class ListarProps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProps() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> props = Properties.getProperties();
		
		//System.out.println("tamanho: " + props.size());
		
		// adiciona atributo no escopo request
		request.setAttribute("props", props);
		
		// redireciona (encaminha) a requisição para o JSP
		request.getRequestDispatcher("/listarProps.jsp").forward(request, response);
	}

}
