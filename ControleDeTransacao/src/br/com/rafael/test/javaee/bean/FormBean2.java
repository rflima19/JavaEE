package br.com.rafael.test.javaee.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafael.test.javaee.ejb.MyBean4;

@Named("form2")
@RequestScoped
public class FormBean2 implements Serializable {

	@EJB
	private MyBean4 myBean4;
	
	public String executar() {
		this.myBean4.mA();
		return null;
	}
}
