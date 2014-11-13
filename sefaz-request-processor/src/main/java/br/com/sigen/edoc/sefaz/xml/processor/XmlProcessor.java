package br.com.sigen.edoc.sefaz.xml.processor;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class XmlProcessor {

	@Resource(mappedName = "java:/jms/queue/requestXmlSefazTransmission")
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
		sendMessage("\n Enviando para transmissão SEFAZ: " + message + "\n");
	}

}
