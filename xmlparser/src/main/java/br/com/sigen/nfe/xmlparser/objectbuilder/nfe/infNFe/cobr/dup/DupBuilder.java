package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.cobr.dup;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Cobr.Dup;

public class DupBuilder implements ObjectBuilder<Dup> {

	@Override
	public Dup build(Map<String, Object> map) throws ObjectBuilderException {
		Dup dup = new ObjectFactory().createTNFeInfNFeCobrDup();

		return dup;
	}
}
