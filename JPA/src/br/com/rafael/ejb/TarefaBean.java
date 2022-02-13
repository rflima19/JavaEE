package br.com.rafael.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafael.model.Tarefa;

@Stateless
public class TarefaBean implements TarefaBeanLocal {

	// o proprio container EJB controla as transações
	@PersistenceContext(unitName = "APPTestJPA")
	private EntityManager em;

	@Override
	public void inserir(Tarefa tarefa) {
		this.em.persist(tarefa);
	}

	@Override
	public void atualizar(Tarefa tarefa) {
		this.em.merge(tarefa);
	}

	@Override
	public void excluir(Tarefa tarefa) {
		Tarefa t = this.em.merge(tarefa);
		this.em.remove(t);
	}

	@Override
	public Tarefa carregar(int id) {
		Tarefa t = this.em.find(Tarefa.class, id);
		
		return t;
	}

}
