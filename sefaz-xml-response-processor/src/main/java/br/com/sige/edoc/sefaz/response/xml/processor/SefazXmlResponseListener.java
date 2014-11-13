package br.com.sige.edoc.sefaz.response.xml.processor;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "java:/jms/queue/responseXmlSefazTransmission", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "response_xml_sefaz_transmission") })
public class SefazXmlResponseListener implements MessageListener {

	@EJB
	private XmlResponseProcessor xmlTransmissor;

	public void onMessage(Message message) {
		try {
			xmlTransmissor.process(((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
