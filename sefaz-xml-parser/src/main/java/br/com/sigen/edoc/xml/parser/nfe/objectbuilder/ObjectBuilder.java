package br.com.sigen.edoc.xml.parser.nfe.objectbuilder;

import java.util.Map;


public interface ObjectBuilder<T> {

	public T build(Map<String, Object> map) throws ObjectBuilderException;

}
