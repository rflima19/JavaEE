package jsf.javabean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ejb.session.singleton.SessionSingletonBean;
import ejb.session.stateless.SessionStatelessBean;

@Named
//@SessionScoped
@RequestScoped
public class ContadorSingleton implements Serializable {

	private Integer cont = Integer.valueOf(0);

	@EJB
	private SessionSingletonBean singleton;

	public Integer getCont() {
		return cont;
	}

	public void setCont(Integer cont) {
		this.cont = cont;
	}

	public String incrementar() {
		System.out.println("Id singleton: " + this.singleton.getId());
		this.cont = this.singleton.incrementar();
		return null;
	}
}
