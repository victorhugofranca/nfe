package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis.pisoutr;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS.PISOutr;

public class PisOutrBuilder implements ObjectBuilder<PISOutr> {

	@Override
	public PISOutr build(Map<String, Object> map) throws ObjectBuilderException {
		return new ObjectFactory().createTNFeInfNFeDetImpostoPISPISOutr();
	}

}
