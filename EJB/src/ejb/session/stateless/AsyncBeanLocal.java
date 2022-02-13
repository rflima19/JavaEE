package ejb.session.stateless;

import java.util.concurrent.Future;

import javax.ejb.Asynchronous;
import javax.ejb.Local;

@Local
public interface AsyncBeanLocal {

	@Asynchronous
	public void processar();
	
	@Asynchronous
	public Future<Integer> processarERetornar();
}
