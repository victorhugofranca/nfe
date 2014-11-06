package br.com.sigen.nfe.xmlparser.objectbuilder;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.envinfe.EnviNFeBuilder;
import br.inf.portalfiscal.nfe.TEnviNFe;

public class ObjectBuilderFacade {

	public TEnviNFe buildEnviFe(Map<String, Object> data)
			throws ObjectBuilderException {

		ObjectBuilderAbstractFactory objectBuilderFactory = new ObjectBuilderFactory();

		EnviNFeBuilder enviNFeBuilder = (EnviNFeBuilder) objectBuilderFactory
				.createEnviNFeBuilder();

		return enviNFeBuilder.build(data);

	}
}
