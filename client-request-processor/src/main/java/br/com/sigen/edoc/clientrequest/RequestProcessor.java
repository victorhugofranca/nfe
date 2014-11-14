package br.com.sigen.edoc.clientrequest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/requestProcessor")
public class RequestProcessor {

	@EJB
	private ResponsePool responsePool;

	@Resource(mappedName = "java:/jms/queue/requestSefazProcessment")
	private Queue queue;

	@Inject
	private JMSContext context;

	@PostActivate
	private void init() {
	}

	@Path("/processar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void asyncGet(@Suspended final AsyncResponse asyncResponse,
			InputStream incomingData) {

		StringBuilder crunchifyBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}

		responsePool.put(asyncResponse);

		sendMessage("\n Enviando processamento SEFAZ: " + crunchifyBuilder.toString()
				+ "\n");
	}

	public void sendMessage(String txt) {
		try {
			context.createProducer().send(queue, txt);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@PreDestroy
	private void finish() {

	}

}
