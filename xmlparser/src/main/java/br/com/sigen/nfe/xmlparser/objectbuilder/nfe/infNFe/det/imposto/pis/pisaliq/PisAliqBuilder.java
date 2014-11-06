package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pis.pisaliq;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS.PISAliq;

public class PisAliqBuilder implements ObjectBuilder<PISAliq> {

	@Override
	public PISAliq build(Map<String, Object> map) throws ObjectBuilderException {
		return new ObjectFactory().createTNFeInfNFeDetImpostoPISPISAliq();
	}

}
