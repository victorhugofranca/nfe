package br.com.sigen.edoc.clientrequest;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.container.AsyncResponse;

@Singleton
public class ResponsePool {

	private Map<Integer, AsyncResponse> responseMap;

	@PostConstruct
	private void init() {
		responseMap = new LinkedHashMap<Integer, AsyncResponse>();
	}

	public void put(AsyncResponse asyncResponse) {
		responseMap.put(1, asyncResponse);
	}

	public AsyncResponse get(Integer id) {
		return responseMap.get(id);
	}

}
