package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pis.pisqtde;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS.PISQtde;

public class PisQtdeBuilder implements ObjectBuilder<PISQtde> {

	@Override
	public PISQtde build(Map<String, Object> map) throws ObjectBuilderException {
		return new ObjectFactory().createTNFeInfNFeDetImpostoPISPISQtde();
	}

}
