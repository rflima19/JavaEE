package br.com.rafael.test.javaee.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafael.test.javaee.ejb.ItensBean;
import br.com.rafael.test.model.Item;

@Named("form3")
@SessionScoped
public class FormBean3 implements Serializable {

	@EJB
	private ItensBean itemBean;

	@Inject
	private ExternalContext externalContext;

	private List<Item> itens = new ArrayList<>();

	private Item item = new Item();

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String adicionar() {
		this.itens.add(this.item);
		this.itemBean.adicionar(item);
		this.item = new Item();
		return "form3?faces-redirect=true";
	}

	public String remover(Item item) {
		this.itens.remove(item);
		this.itemBean.remover(item.getId());
		return "form3?faces-redirect=true";
	}

	public String finalizar() {
		this.itemBean.finalizar();
		// invalida a sessão corrente já que o stateful session bean associado a sessão
		// foi removido e não existe mais.
		this.externalContext.invalidateSession();
		return "form3?faces-redirect=true";
	}
}
