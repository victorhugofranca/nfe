package br.com.sigen.edoc.sefaz.xml.processor;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.com.sigen.edoc.xml.parser.nfe.XmlGenerator;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;

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
		XmlGenerator xmlGenerator = new XmlGenerator();
		try {
			xmlGenerator.test();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sendMessage("\n Enviando para transmissão SEFAZ: " + message + "\n");
	}

}
