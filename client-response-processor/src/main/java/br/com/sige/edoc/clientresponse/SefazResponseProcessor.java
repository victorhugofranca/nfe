package br.com.sige.edoc.clientresponse;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class SefazResponseProcessor {

	@Resource(mappedName = "java:/jms/queue/clienteResponseProcessment")
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
		sendMessage("\n Resposta do client request: "
				+ message + "\n");
	}

}
