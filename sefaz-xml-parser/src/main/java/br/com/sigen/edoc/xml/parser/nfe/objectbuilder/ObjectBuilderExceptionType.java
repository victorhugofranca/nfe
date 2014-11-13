package br.com.sigen.edoc.xml.parser.nfe.objectbuilder;

public enum ObjectBuilderExceptionType {

	DATA_FORMATO_INVALIDO("DATA_FORMATO_INVALIDO", "Formato de data inválido");

	private String code;
	private String description;

	private ObjectBuilderExceptionType(String codigo, String descricao) {
		setCode(codigo);
		setDescription(descricao);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
