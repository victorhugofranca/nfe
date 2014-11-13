package br.com.sige.edoc.sefaz.response.xml.processor;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class XmlResponseProcessor {

	@Resource(mappedName = "java:/jms/queue/responseSefazProcessment")
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
		sendMessage("\n Processando retorno da transmissão da SEFAZ: "
				+ message + "\n");
	}

}
