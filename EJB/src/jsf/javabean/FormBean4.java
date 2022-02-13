package jsf.javabean;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ejb.session.stateless.AsyncBeanLocal;

@Named("form4")
@SessionScoped
public class FormBean4 implements Serializable {

	@EJB
	private AsyncBeanLocal asyncBean;
	
	private String mensagem;
	
	private Future<Integer> future;

	public String getMensagem() {
		return mensagem;
	}
	
	public String executar() {
		this.asyncBean.processar();
		this.mensagem = "processamento iniciado";
		return null; 
	}
	
	public String executar2() {
		this.future = this.asyncBean.processarERetornar();
		this.mensagem = "processamento iniciado";
		return null; 
	}

	public void verificar() {
		if (!this.future.isDone()) {
			this.mensagem = "processamento em andamento";
		} else {
			try {
				this.mensagem = "resultado: " + this.future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
