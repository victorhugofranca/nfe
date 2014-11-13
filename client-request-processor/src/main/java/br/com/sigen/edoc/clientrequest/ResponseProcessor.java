package br.com.sigen.edoc.clientrequest;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

//@Stateless
// @Path("/responseProcessor")
@MessageDriven(mappedName = "java:/jms/queue/responseSefazProcessment", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "response_sefaz_processment") })
public class ResponseProcessor implements MessageListener {

	@EJB
	private ResponsePool responsePool;

	public void onMessage(Message message) {
		try {
			responsePool.get(1).resume(
					"Respondendo..." + ((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
