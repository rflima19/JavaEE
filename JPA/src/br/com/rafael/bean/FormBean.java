package br.com.rafael.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafael.ejb.TarefaBean2;
import br.com.rafael.ejb.TarefaBeanLocal;
import br.com.rafael.model.Tarefa;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {

	@EJB
	private TarefaBeanLocal tarefaBean;
	
//	@EJB
//	private TarefaBean2 tarefaBean;
	
	@Inject
	private FacesContext context;
	
	private Tarefa tarefa;

	private Integer tarefaID;

	private UIComponent searchInputText;

	public Tarefa getTarefa() {
		if (this.tarefa == null) {
			this.tarefa = new Tarefa();
		}
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Integer getTarefaID() {
		return tarefaID;
	}

	public void setTarefaID(Integer tarefaID) {
		this.tarefaID = tarefaID;
	}

	public UIComponent getSearchInputText() {
		return searchInputText;
	}

	public void setSearchInputText(UIComponent searchInputText) {
		this.searchInputText = searchInputText;
	}

	public void pesquisar(AjaxBehaviorEvent event) {
		this.tarefa = this.tarefaBean.carregar(this.tarefaID);
		
		if (this.tarefa == null) {
			this.context.addMessage(this.searchInputText.getClientId(this.context), new FacesMessage("Tarefa não encontrada"));
		}
		
		this.tarefaID = null;
	}

	public void gravar(AjaxBehaviorEvent event) {
		if (this.tarefa.getId() == null ) {
			this.tarefaBean.inserir(this.tarefa);
		} else {
			this.tarefaBean.atualizar(this.tarefa);
		}
		this.tarefa = null;
	}

	public void excluir(AjaxBehaviorEvent event) {
		//if (this.tarefa != null) {
			this.tarefaBean.excluir(this.tarefa);
			this.tarefa = null;
		//}
	}
}
