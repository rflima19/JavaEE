package ejb.exercicio2;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class EjbContadorBean {

	private Integer cont;
	
	@PostConstruct
	public void inicializar() {
		this.cont = Integer.valueOf(0);
	}
	
	public void incrementar() {
		++this.cont;
	}
	
	public Integer getCont() {
		return this.cont;
	}
}
