package jsf.javabean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.session.stateful.ItensBeanLocal;

@Named("form2")
@SessionScoped
public class FormBean2 implements Serializable {

	/*
	 * Faz com que o container web injete os parâmetros vindos na requisição do
	 * cliente
	 */
	@Inject
	@RequestParameterMap
	private Map<String, String> parametrosRequisicao;

	@EJB
	private ItensBeanLocal itensBean;
	
	private String item;
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<String> getItens() {
		return this.itensBean.getItens();
	}

	public void adicionar(AjaxBehaviorEvent event) {
		this.itensBean.adicionarItem(this.item);
		this.item = null;
	}

	public void remover(AjaxBehaviorEvent event) {
		String item = this.parametrosRequisicao.get("itemParaRemover");
		this.itensBean.removerItem(item);
	}

}
