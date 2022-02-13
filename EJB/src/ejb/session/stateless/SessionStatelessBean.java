package ejb.session.stateless;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class SessionStatelessBean {

	private Integer cont = 0;
	private Integer id;
	
	@PostConstruct
	public void gerarId() {
		this.id = new Random().nextInt();
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer incrementar() {
		return ++this.cont;
	}
}
