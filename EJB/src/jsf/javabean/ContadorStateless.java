package jsf.javabean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ejb.session.stateless.SessionStatelessBean;

@Named
//@SessionScoped
@RequestScoped
public class ContadorStateless implements Serializable {

	private Integer cont = Integer.valueOf(0);

	@EJB
	private SessionStatelessBean stateless;

	public Integer getCont() {
		return cont;
	}

	public void setCont(Integer cont) {
		this.cont = cont;
	}

	public String incrementar() {
		//System.out.println("Hashcode que identifica objeto stateless que atendeu a requisição:" + this.stateless.hashCode());
		//System.out.println("stateless:" + this.stateless.toString());
		System.out.println("Id stateless: " + this.stateless.getId());
		this.cont = this.stateless.incrementar();
		return null;
	}
}
