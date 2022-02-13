package ejb.messagedriven;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/SoftQueue") },
		mappedName = "java:/jms/queue/SoftQueue")
public class QueueReceiver implements MessageListener {

	public QueueReceiver() {
	}
	
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			String mensagem = textMessage.getText();
			System.out.println("Mensagem lida da fila: " + mensagem);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
