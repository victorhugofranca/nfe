package br.com.sigen.edoc.xml.parser.nfe;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NfeDataPool {

	private static NfeDataPool instance;
	private Map<String, JSONObject> nfeDataMap;

	private NfeDataPool() {
		nfeDataMap = new LinkedHashMap<String, JSONObject>();
	}

//	public static NfeDataPool instance() {
//		if (instance == null) {
//			instance = new NfeDataPool();
//		}
//		return instance;
//	}

	public void addNfeData(String nfeId, String json) {

		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject) parser.parse(json);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Erro ao realizar parse do Json de identificador: " + nfeId);
		}

		nfeDataMap.put(nfeId, jsonObject);
	}

	public Map<String, Object> value(String nfeId)
			throws NfeDataNotFoundException {
		JSONObject jsonObject = nfeDataMap.get(nfeId);

		if (jsonObject == null)
			throw new NfeDataNotFoundException();

		return nfeDataMap.get(nfeId);
	}

	public String value(String nfeId, String attribute)
			throws NfeDataNotFoundException {

		JSONObject jsonObject = nfeDataMap.get(nfeId);

		if (jsonObject == null)
			throw new NfeDataNotFoundException();

		Object value = jsonObject.get(attribute);
		if (value != null) {
			return String.valueOf(jsonObject.get(attribute));
		}

		return null;
	}

	public int itensSize(String nfeId) {

		JSONObject jsonObject = nfeDataMap.get(nfeId);

		return ((JSONArray) jsonObject.get("itens")).size();

	}

	public Iterator<Map<String, String>> itensIterator(String nfeId) {

		JSONObject jsonObject = nfeDataMap.get(nfeId);

		return ((JSONArray) jsonObject.get("itens")).iterator();
	}

}
