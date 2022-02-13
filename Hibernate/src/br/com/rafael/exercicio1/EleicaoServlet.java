package br.com.rafael.exercicio1;

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
 * Servlet implementation class EleicaoServlet
 */
@WebServlet(description = "Salva os dados da eleição no banco de dados", urlPatterns = { "/eleicao" })
public class EleicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EleicaoServlet() {
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

			Cargo cargoSenador = new Cargo();
			cargoSenador.setNome(Cargo.NomeCargo.SENADOR.toString());
			session.save(cargoSenador);
			
			Cargo cargoPresidente = new Cargo();
			cargoPresidente.setNome(Cargo.NomeCargo.PRESIDENTE.toString());
			session.save(cargoPresidente);
			
			Cargo cargoPrefeito = new Cargo();
			cargoPrefeito.setNome(Cargo.NomeCargo.PREFEITO.toString());
			session.save(cargoPrefeito);
			
			Candidato c1 = new Candidato();
			c1.setNome("André Costa");
			c1.setCargo(cargoSenador);
			session.save(c1);
			
			Candidato c2 = new Candidato();
			c2.setNome("José Santos");
			c2.setCargo(cargoPresidente);
			session.save(c2);
			
			Candidato c3 = new Candidato();
			c3.setNome("Marcos Silva");
			c3.setCargo(cargoPrefeito);
			session.save(c3);

			Candidato c4 = new Candidato();
			c4.setNome("Matias Rizon");
			c4.setCargo(cargoPrefeito);
			session.save(c4);
			
			Candidato c5 = new Candidato();
			c5.setNome("Osmar Aquino");
			c5.setCargo(cargoPresidente);
			session.save(c5);
			
			Candidato c6 = new Candidato();
			c6.setNome("Ramon Teixeira");
			c6.setCargo(cargoSenador);
			session.save(c6);
			
			Eleitor e1 = new Eleitor();
			e1.setTituloEleitor("12648");
			e1.setNome("Luis Kirk");
			session.save(e1);
			
			Eleitor e2 = new Eleitor();
			e2.setTituloEleitor("56723");
			e2.setNome("Rafael Jamelka");
			session.save(e2);
			
			Eleitor e3 = new Eleitor();
			e3.setTituloEleitor("89192");
			e3.setNome("Murilo Dias");
			session.save(e3);
			
			Voto v1 = new Voto();
			v1.setCandidato(c1);
			v1.setEleitor(e1);
			session.save(v1);
			
			Voto v2 = new Voto();
			v2.setCandidato(c2);
			v2.setEleitor(e1);
			session.save(v2);
			
			Voto v3 = new Voto();
			v3.setCandidato(c3);
			v3.setEleitor(e1);
			session.save(v3);
			
			Voto v4 = new Voto();
			v4.setCandidato(c1);
			v4.setEleitor(e2);
			session.save(v4);
			
			Voto v5 = new Voto();
			v5.setCandidato(c2);
			v5.setEleitor(e2);
			session.save(v5);
			
			Voto v6 = new Voto();
			v6.setCandidato(c4);
			v6.setEleitor(e2);
			session.save(v6);
			
			Voto v7 = new Voto();
			v7.setCandidato(c4);
			v7.setEleitor(e3);
			session.save(v7);
			
			Voto v8 = new Voto();
			v8.setCandidato(c5);
			v8.setEleitor(e3);
			session.save(v8);
			
			Voto v9 = new Voto();
			v9.setCandidato(c6);
			v9.setEleitor(e3);
			session.save(v9);
			
			trans.commit();

		} catch (HibernateException e) {
			throw new ServletException(e);
		}
	}

	private <T> void save(Session session, T obj) {
		session.save(obj);
	}
	
	private void saveCargo(Session session, Cargo.NomeCargo tipoCargo) {
		Cargo cargo = new Cargo();
		cargo.setNome(tipoCargo.toString());
		this.save(session, cargo);
	}
}
