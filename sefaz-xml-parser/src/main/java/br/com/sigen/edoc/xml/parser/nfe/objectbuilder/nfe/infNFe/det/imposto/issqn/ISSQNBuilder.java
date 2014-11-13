package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.issqn;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.ISSQN;

public class ISSQNBuilder implements ObjectBuilder<ISSQN> {

	@Override
	public ISSQN build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		ISSQN issqn = objectFactory.createTNFeInfNFeDetImpostoISSQN();
		return issqn;
	}
}
