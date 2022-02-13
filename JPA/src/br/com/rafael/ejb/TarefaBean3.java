package br.com.rafael.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.rafael.model.Tarefa;

@Stateless
@TransactionAttribute (TransactionAttributeType.NEVER)
public class TarefaBean3 {

	// o proprio container EJB controla as transações
	@PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "APPTestJPA")
	private EntityManager em;

	public void inserir(Tarefa tarefa) {
		this.em.persist(tarefa);
	}

	public void atualizar(Tarefa tarefa) {
		this.em.merge(tarefa);
	}

	public void excluir(Tarefa tarefa) {
		Tarefa t = this.em.merge(tarefa);
		this.em.remove(t);
	}

	public Tarefa carregar(int id) {
		Tarefa t = this.em.find(Tarefa.class, id);
		
		System.out.println(this.em.contains(t));
		
		Tarefa t2 = this.em.find(Tarefa.class, id);
		
		System.out.println(t == t2);
		
		return t;
	}

}
