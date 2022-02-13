package br.com.rafael.exercicio2;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@Named("contador")
@SessionScoped
public class ContadorBean implements Serializable {

	private Integer cont;

	public ContadorBean() {
		super();
		this.cont = Integer.valueOf(0);
	}

	public Integer getCont() {
		return cont;
	}

	public void setCont(Integer cont) {
		this.cont = cont;
	}
	
	public void contar(AjaxBehaviorEvent event) {
		++this.cont;
	}
}
