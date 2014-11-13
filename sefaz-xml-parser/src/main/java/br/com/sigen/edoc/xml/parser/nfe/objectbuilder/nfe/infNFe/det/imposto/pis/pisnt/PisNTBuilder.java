package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis.pisnt;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS.PISNT;

public class PisNTBuilder implements ObjectBuilder<PISNT> {

	@Override
	public PISNT build(Map<String, Object> map) throws ObjectBuilderException {
		return new ObjectFactory().createTNFeInfNFeDetImpostoPISPISNT();
	}

}
