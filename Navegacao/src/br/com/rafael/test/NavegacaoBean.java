package br.com.rafael.test;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named("nav")
@RequestScoped
public class NavegacaoBean implements Serializable {

	public enum pages {
		PAGE_A, PAGE_B;
	}
	
	private String page;
	
	private String nome;
	
//	@Inject
//	private Flash flash;
	
	public String goTo() {
		if ("a".equals(this.page)) {
			return "page_a";
		} else if ("b".equals(this.page)) {
			return "page_b";
		} else {
			return null;
		}
	}
	
	public String goTo2() {
		if ("a".equals(this.page)) {
			return NavegacaoBean.pages.PAGE_A.toString().toLowerCase();
		} else if ("b".equals(this.page)) {
			return NavegacaoBean.pages.PAGE_B.toString().toLowerCase();
		} else {
			return null;
		}
	}

	public String processar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		Flash f = ec.getFlash();
		f.put("nome", this.nome);
		return "result?faces-redirect=true";
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
