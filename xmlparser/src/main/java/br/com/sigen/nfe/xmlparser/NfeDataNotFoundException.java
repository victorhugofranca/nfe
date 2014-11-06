package br.com.sigen.nfe.xmlparser;

public class NfeDataNotFoundException extends Exception {

	private static final long serialVersionUID = 9068006392619189745L;

	@Override
	public String getMessage() {
		return "Não foram encontrados dados para o identificador de registro informado";
	}

}
