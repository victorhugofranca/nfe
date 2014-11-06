package br.com.sigen.nfe.xmlparser.objectbuilder;

import java.util.Map;


public interface ObjectBuilder<T> {

	public T build(Map<String, Object> map) throws ObjectBuilderException;

}
