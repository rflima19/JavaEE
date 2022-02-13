package ejb.session.stateless;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AsyncBean
 */
@Stateless
@LocalBean
public class AsyncBean implements AsyncBeanLocal {

    public AsyncBean() {
    }

	@Override
	@Asynchronous
	public void processar() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	@Asynchronous
	public Future<Integer> processarERetornar() {
		int soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += i;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return new AsyncResult<Integer>(soma);
	}

}
