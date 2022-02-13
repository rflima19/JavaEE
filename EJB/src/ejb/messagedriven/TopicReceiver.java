package ejb.messagedriven;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import jsf.javabean.Produto;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/topic/SoftTopic") },
		mappedName = "java:/jms/topic/SoftTopic")
public class TopicReceiver implements MessageListener {

	public TopicReceiver() {
	}
	
	@Override
	public void onMessage(Message message) {
		ObjectMessage objMessage = (ObjectMessage) message;
		try {
			Produto obj = (Produto) objMessage.getObject();
			System.out.println("Mensagem lida do topic: " + obj);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
