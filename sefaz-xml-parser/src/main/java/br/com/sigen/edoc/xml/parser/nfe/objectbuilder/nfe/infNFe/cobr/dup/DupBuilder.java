package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.cobr.dup;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Cobr.Dup;

public class DupBuilder implements ObjectBuilder<Dup> {

	@Override
	public Dup build(Map<String, Object> map) throws ObjectBuilderException {
		Dup dup = new ObjectFactory().createTNFeInfNFeCobrDup();

		return dup;
	}
}
