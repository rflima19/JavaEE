package br.com.rafael.test.inicializacaoautomatica;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AutoInit1Servlet
 */
// O atributo initParams permite definir par�metros de inicializa��o para o Servlet
// O atributo loadOnStartup define a inicializa��o autom�tica
@WebServlet(
		initParams = { 
				@WebInitParam(name = "adminNumero", value = "2345-6276", description = "N�mero do administrador do sistema")
		}, 
		description = "Servlet de inicializa��o automatica configurado atrav�s de annotation",
		loadOnStartup = 3)
public class AutoInit2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String numero = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoInit2Servlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String numero = config.getInitParameter("adminEmail");
		this.numero = numero;
		
		System.out.println("Servlet carregado, N�mero do admin = " + this.numero);
	}

}
