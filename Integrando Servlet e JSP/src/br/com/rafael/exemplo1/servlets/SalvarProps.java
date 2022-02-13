package br.com.rafael.exemplo1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafael.exemplo1.model.Properties;

/**
 * Servlet implementation class SalvarProps
 */
@WebServlet(description = "Salva os dados da propriedade", urlPatterns = { "/salvar" })
public class SalvarProps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalvarProps() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// obtem os parametros passados na requisição
		String id = request.getParameter("id");
		String valor = request.getParameter("valor");
		
		if ((id != null) && !(id.isEmpty())) {
			Properties.save(id, valor);
		}
		
		// redireciona para o servelt listar
		response.sendRedirect("/integracao/listar");
	}

}
