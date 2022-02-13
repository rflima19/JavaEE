package br.com.rafael.test.associacoes;

import java.io.IOException;
import java.time.LocalDate;

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
 * Servlet implementation class AssociacoesServlet
 */
@WebServlet(description = "Testa as associações no Hibernate", urlPatterns = { "/associacoes" })
public class AssociacoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssociacoesServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Configuration cfg = new Configuration().configure();

		try {
			SessionFactory sf = cfg.buildSessionFactory();

			Session session = sf.getCurrentSession();

			Transaction trans = session.beginTransaction();

			Cliente c = new Cliente();
			c.setNome("Luiza");
			session.save(c);
			
			RG rg = new RG();
			rg.setNumero("1234567");
			rg.setDataExpedicao(LocalDate.now());
			rg.setCliente(c);
			session.save(rg);
			
			Editora edit = new Editora();
			edit.setNome("Edit");
			session.save(edit);
			
			Livro l = new Livro();
			l.setNome("Java");
			l.setAutor("João José");
			l.setIsbn("938823744");
			l.setEditora(edit);
			session.save(l);
			
			//c.getLivros().add(l);
			l.getClientes().add(c);
			
			trans.commit();

		} catch (HibernateException e) {
			throw new ServletException(e);
		}
	}

}
