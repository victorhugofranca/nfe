package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.icms.icms60;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.ICMS.ICMS60;

public class Icms60Builder implements ObjectBuilder<ICMS60> {

	@Override
	public ICMS60 build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();

		ICMS60 icms60 = objectFactory.createTNFeInfNFeDetImpostoICMSICMS60();

		icms60.setCST(String.valueOf(map.get("icms_situacao_tributaria")));
		icms60.setOrig(String.valueOf(map.get("icms_origem")));

		return icms60;
	}
}
