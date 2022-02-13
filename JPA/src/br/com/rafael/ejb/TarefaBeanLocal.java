package br.com.rafael.ejb;

import javax.ejb.Local;

import br.com.rafael.model.Tarefa;

@Local
public interface TarefaBeanLocal {

	public void inserir(Tarefa tarefa);
	
	public void atualizar(Tarefa tarefa);
	
	public void excluir(Tarefa tarefa);
	
	public Tarefa carregar(int id);
}
