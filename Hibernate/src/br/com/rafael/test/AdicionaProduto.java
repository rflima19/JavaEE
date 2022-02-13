package br.com.rafael.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Servlet implementation class AdicionaProduto
 */
@WebServlet(description = "Adiciona um novo produto no banco de dados", urlPatterns = { "/produto/add" })
public class AdicionaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaProduto() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");
		String result = null;
		
		if ((nome != null) && (valor != null)) {
			
			// objeto que carrega as conigura��es definidas no arquivo hibernate.cfg.xml
			Configuration confg = new Configuration().configure();

			try {

				// Objeto responsavel por criar Session. Deve ser um objeto �nico na aplica��o.
				SessionFactory sf = confg.buildSessionFactory();

				Session session = sf.getCurrentSession();

				// Apartir desse ponto a aplica��o j� esta conectada com o banco de dados

				// cria o objeto a ser salvo no banco
				Produto p = new Produto();
				p.setNome(nome);
				p.setValor(Double.valueOf(valor));

				// inicia um transa��o no banco de dados
				Transaction trans = session.beginTransaction();

				// salva o objeto no banco
				session.save(p);

				// finaliza a transa��o
				//session.getTransaction().commit();
				trans.commit();
				
				result = "Produto cadastrado com sucesso!!!";
				
			} catch (NumberFormatException e) {
				result = "Produto n�o cadastrado, valor de pre�o invalido!!!";
				e.printStackTrace();
			} catch (HibernateException e) {
				result = "Produto n�o cadastrado, erro na base de dados!!!";
				e.printStackTrace();
			}
		} else {
			result = "Produto n�o cadastrado. ";
			if (nome != null) {
				result += "Nome invalido. ";
			} 
			if (valor != null) {
				result += "Valor invalido.";
			}
		}
		
		request.getSession().setAttribute("result", result);
		response.sendRedirect("/Hibernate/result.jsp");
	}

}
