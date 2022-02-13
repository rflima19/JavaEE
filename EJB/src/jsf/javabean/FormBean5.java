package jsf.javabean;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Topic;

import ejb.session.stateless.AsyncBeanLocal;

@Named("form5")
@RequestScoped
public class FormBean5 implements Serializable {

	@Resource
	private ConnectionFactory connection;
	
	@Resource(mappedName = "java:/jms/queue/SoftQueue")
	private Queue queue;
	
	@Resource(mappedName = "java:/jms/topic/SoftTopic")
	private Topic topic;
	
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String enviar() {
		JMSContext context =  this.connection.createContext();
		JMSProducer producer = context.createProducer();
		
		producer.send(this.queue, this.mensagem);
		
		Produto p = new Produto(1, "P1");
		producer.send(topic, p);
		
		return null;
	}

}
