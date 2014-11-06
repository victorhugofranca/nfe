package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pisst;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PISST;

public class PISSTBuilder implements ObjectBuilder<PISST> {

	@Override
	public PISST build(Map<String, Object> map) throws ObjectBuilderException {
		return new ObjectFactory().createTNFeInfNFeDetImpostoPISST();
	}

}
