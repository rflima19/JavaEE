package ejb.session.singleton;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Singleton
public class SessionSingletonBean {

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
		return ++cont;
	}
}
