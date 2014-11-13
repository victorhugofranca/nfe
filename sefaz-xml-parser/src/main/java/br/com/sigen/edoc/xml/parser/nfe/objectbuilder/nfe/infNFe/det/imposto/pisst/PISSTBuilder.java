package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pisst;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PISST;

public class PISSTBuilder implements ObjectBuilder<PISST> {

	@Override
	public PISST build(Map<String, Object> map) throws ObjectBuilderException {
		return new ObjectFactory().createTNFeInfNFeDetImpostoPISST();
	}

}
