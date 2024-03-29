package br.com.sigen.edoc.sefaz.request.xml.transmissor;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class XmlTransmissor {

	@Resource(mappedName = "java:/jms/queue/responseXmlSefazTransmission")
	private Queue queue;

	@Inject
	private JMSContext context;

	private void sendMessage(String txt) {
		try {
			context.createProducer().send(queue, txt);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void process(String message) {
		sendMessage("\n Enviando retorno do XML enviado para SEFAZ: " + message
				+ "\n");
	}

}
