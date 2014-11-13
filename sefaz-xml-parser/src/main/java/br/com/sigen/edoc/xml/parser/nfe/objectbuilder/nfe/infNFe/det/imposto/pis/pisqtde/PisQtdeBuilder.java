package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis.pisqtde;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS.PISQtde;

public class PisQtdeBuilder implements ObjectBuilder<PISQtde> {

	@Override
	public PISQtde build(Map<String, Object> map) throws ObjectBuilderException {
		return new ObjectFactory().createTNFeInfNFeDetImpostoPISPISQtde();
	}

}
