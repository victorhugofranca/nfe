package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pis.pisnt;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS.PISNT;

public class PisNTBuilder implements ObjectBuilder<PISNT> {

	@Override
	public PISNT build(Map<String, Object> map) throws ObjectBuilderException {
		return new ObjectFactory().createTNFeInfNFeDetImpostoPISPISNT();
	}

}
