package br.com.sigen.edoc.request.triagem.engine;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class TriagemEngine {

	@Resource(mappedName = "java:/jms/queue/requestSefazProcessment")
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
		sendMessage("\n Mensagem saindo da triagem: " + message + "\n");
	}

}
