package br.com.rafael.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.rafael.model.Tarefa;

@Stateless
public class TarefaBean2 implements Serializable {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("APPTestJPA");

	public synchronized void inserir(Tarefa tarefa) {
		EntityManager em = TarefaBean2.factory.createEntityManager();

		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();

			em.persist(tarefa);

			trans.commit();

			em.close();
			
			TarefaBean2.factory.close();
		} catch (Exception e) {
			trans.rollback();
		}
	}

	public synchronized void atualizar(Tarefa tarefa) {
		EntityManager em = TarefaBean2.factory.createEntityManager();

		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();

			em.merge(tarefa);

			trans.commit();

			em.close();
			
			TarefaBean2.factory.close();
		} catch (Exception e) {
			trans.rollback();
		}
	}

	public synchronized void excluir(Tarefa tarefa) {
		EntityManager em = TarefaBean2.factory.createEntityManager();

		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();

			Tarefa t = em.merge(tarefa);

			em.remove(t);

			trans.commit();

			em.close();
			
			TarefaBean2.factory.close();
		} catch (Exception e) {
			trans.rollback();
		}
	}

	public synchronized Tarefa carregar(int id) {
		EntityManager em = TarefaBean2.factory.createEntityManager();

		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();

			Tarefa t = em.find(Tarefa.class, id);

			//Tarefa t2 = em.find(Tarefa.class, id);
			
			//System.out.println(t == t2);
			
			trans.commit();

			em.close();
			
			TarefaBean2.factory.close();

			return t;
		} catch (Exception e) {
			trans.rollback();
		}
		
		return null;
	}

}
