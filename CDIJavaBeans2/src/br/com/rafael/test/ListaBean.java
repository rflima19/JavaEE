package br.com.rafael.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
//@RequestScoped
//@SessionScoped
//@ApplicationScoped
@ConversationScoped
public class ListaBean implements Serializable {

	private static final long serialVersionUID = -1470969040276231118L;

	private String item;
	
	private List<String> itens;
	
	@Inject
	private Conversation conversation;
	
	public ListaBean() {
		super();
		this.itens = new ArrayList<String>();
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<String> getItens() {
		return itens;
	}

	public void setItens(List<String> itens) {
		this.itens = itens;
	}
	
	public String adicionar() {
		if (itens.size() == 0) {
			conversation.begin();
		}
		
		this.itens.add(this.item);
//		for (String string : itens) {
//			System.out.println(string);
//		}
		this.item = null;
		return null;
	}
	
	public String removerTudo() {
		if (itens.size() > 0) {
			itens.clear();
			conversation.end();
		}

		return null;
	}
}
