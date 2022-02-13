package br.com.rafael.test.hql;

import java.io.IOException;
import java.util.List;

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
import org.hibernate.query.Query;

import br.com.rafael.test.associacoes.Cliente;
import br.com.rafael.test.associacoes.Livro;
import br.com.rafael.test.associacoes.RG;

/**
 * Servlet implementation class HQLServlet
 */
@WebServlet(description = "Testando a linguagem HQL", urlPatterns = { "/HQL" })
public class HQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HQLServlet() {
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

			/*
			 * Quando escrever consultas HQL (ou JPQL), usa os nomes dos tipos (entidades),
			 * não o nome das tabelas do banco de dados.
			 */
			
//			String hql = "FROM Livro";
//			Query<Livro> q = session.createQuery(hql);
//			List<Livro> l = q.list();
//
//			for (Livro livro : l) {
//				System.out.println("isbn: " + livro.getIsbn());
//				System.out.println("nome: " + livro.getNome());
//				System.out.println("autor: " + livro.getAutor());
//				System.out.println("editora: " + livro.getEditora().getNome());
//				System.out.println("Clientes:");
//				for (Cliente c : livro.getClientes()) {
//					System.out.println("nome: " + c.getNome());
//					System.out.println("---------------------------------------------");
//				}
//				System.out.println("---------------------------------------------");
//			}

//			String hql = "SELECT l.isbn FROM Livro l";
//			Query<String> q = session.createQuery(hql);
//			List<String> l = q.list();
//
//			for (String isbn : l) {
//				System.out.println("isbn: " + isbn);
//				System.out.println("---------------------------------------------");
//			}
			
//			String hql = "SELECT l.isbn, l.nome FROM Livro l";
//			Query<Object[]> q = session.createQuery(hql);
//			List<Object[]> l = q.list();
//
//			for (Object[] obj : l) {
//				System.out.println("isbn: " + obj[0]);
//				System.out.println("nome: " + obj[1]);
//				System.out.println("---------------------------------------------");
//			}
			
//			String hql = "SELECT c FROM Cliente c INNER JOIN c.livros l";
//			Query<Cliente> q = session.createQuery(hql);
//			List<Cliente> l = q.list();
//
//			for (Cliente c : l) {
//				System.out.println("nome: " + c.getNome());
//				System.out.println("rg: " + c.getRg().getNumero());
//				System.out.println("---------------------------------------------");
//			}
			
//			String hql = "SELECT l FROM Livro l WHERE l.editora.nome = 'Edit'";
//			Query<Livro> q = session.createQuery(hql);
//			List<Livro> l = q.list();
//
//			for (Livro livro : l) {
//				System.out.println("isbn: " + livro.getIsbn());
//				System.out.println("nome: " + livro.getNome());
//				System.out.println("autor: " + livro.getAutor());
//				System.out.println("editora: " + livro.getEditora().getNome());
//				System.out.println("---------------------------------------------");
//			}
			
			String hql = "SELECT r FROM RG r WHERE r.cliente.nome LIKE 'L%'";
			Query<RG> q = session.createQuery(hql);
			List<RG> l = q.list();

			for (RG rg : l) {
				System.out.println("número do rg: " + rg.getNumero());
				System.out.println("data de expedição do rg: " + rg.getDataExpedicao());
				System.out.println("---------------------------------------------");
			}
			
			trans.commit();

		} catch (HibernateException e) {
			throw new ServletException(e);
		}
	}

}
