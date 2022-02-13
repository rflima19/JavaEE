package jsf.javabean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ejb.session.stateful.SessionStatefulBean;
import ejb.session.stateless.SessionStatelessBean;

@Named
//@SessionScoped
@RequestScoped
public class ContadorStateful implements Serializable {

	private Integer cont = Integer.valueOf(0);
	
	@EJB
	private SessionStatefulBean stateful;
	
	public Integer getCont() {
		return cont;
	}

	public void setCont(Integer cont) {
		this.cont = cont;
	}
	
	public String incrementar() {
		System.out.println("Id stateful: " + this.stateful.getId());
		this.cont = this.stateful.incrementar();
		return null;
	}
}
