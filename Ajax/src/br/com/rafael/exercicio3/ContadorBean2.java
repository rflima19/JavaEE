package br.com.rafael.exercicio3;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@Named("contador2")
@RequestScoped
public class ContadorBean2 implements Serializable {

	private Integer cont;

	public ContadorBean2() {
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
