package br.com.rafael.test.javaee.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafael.test.javaee.ejb.MyBean;
import br.com.rafael.test.javaee.ejb.MyBean2;

@Named("form1")
@RequestScoped
public class FormBean implements Serializable {

//	@EJB
//	private MyBean myBean;
	
	@EJB
	private MyBean2 myBean2;
	
	public String executar() {
		this.myBean2.mA();
		return null;
	}
}
