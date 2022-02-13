package ejb.exercicio2;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("cont")
@RequestScoped
public class ContadorBean implements Serializable {

	@EJB
	private EjbContadorBean contador;

	public String incrementar() {
		this.contador.incrementar();
		return null;
	}
	
	public Integer getCont() {
		return this.contador.getCont();
	}
}
