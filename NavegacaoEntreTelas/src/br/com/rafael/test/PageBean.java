package br.com.rafael.test;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean implements Serializable {

	public enum Pages {
		page_a, page_b;
	}

	private String page;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

//	public String goTo() {
//		if (this.page.equals("a")) {
//			return "page_a";
//		} else if (this.page.equals("b")){
//			return "page_b";
//		}
//		return null;
//	}

	/*
	 * O retorno pode ser qualquer objeto, mas não pode ser void. O retorno pode ser
	 * qualquer objeto desde que o objeto retornado tenha o método toString para
	 * retorna o outcome que deve ser uma String.
	 */
	public Pages goTo() {
		if (this.page.equals("a")) {
			return Pages.page_a;
		} else if (this.page.equals("b")) {
			return Pages.page_b;
		}
		return null;
	}
}
