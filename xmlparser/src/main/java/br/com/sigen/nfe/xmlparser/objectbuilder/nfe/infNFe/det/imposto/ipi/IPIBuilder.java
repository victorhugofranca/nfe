package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.ipi;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TIpi;

public class IPIBuilder implements ObjectBuilder<TIpi> {

	@Override
	public TIpi build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		TIpi ipi = objectFactory.createTIpi();
		return ipi;

	}
}
