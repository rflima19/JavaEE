package ejb.session.stateful;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class SessionStatefulBean {

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
