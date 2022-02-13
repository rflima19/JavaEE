package br.com.rafael.exercicio1;

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

@WebServlet(description = "Consulta os dados da eleição no banco de dados", urlPatterns = { "/consultaEleicao" })
public class ConsultaDadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultaDadosServlet() {
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

//			String hql = "SELECT c.nome FROM Candidato AS c WHERE c.cargo.nome = 'PRESIDENTE' ORDER BY c.nome";
//			Query<String> query = session.createQuery(hql);
//			List<String> l = query.getResultList();
//
//			for (String nome : l) {
//				System.out.println("Nome Candidado a Presidente: " + nome);
//				System.out.println("-------------------------------------------------");
//			}
			
//			String hql = "SELECT v.candidato FROM Voto v WHERE v.eleitor.tituloEleitor = '56723'";
//			Query<Candidato> query = session.createQuery(hql);
//			List<Candidato> l = query.getResultList();
//
//			for (Candidato c : l) {
//				System.out.println("Nome Candidado: " + c.getNome());
//				System.out.println("Cargo Candidado: " + c.getCargo().getNome());
//				System.out.println("-------------------------------------------------");
//			}
			
			String hql = "SELECT v.candidato.nome, COUNT(*) FROM Voto v GROUP BY v.candidato.id";
			Query<Object[]> query = session.createQuery(hql);
			List<Object[]> l = query.getResultList();

			for (Object[] obj : l) {
				System.out.println("Nome Candidado: " + obj[0]);
				System.out.println("Número de Votos: " + obj[1]);
				System.out.println("-------------------------------------------------");
			}

			trans.commit();

		} catch (HibernateException e) {
			throw new ServletException(e);
		}
	}
}
