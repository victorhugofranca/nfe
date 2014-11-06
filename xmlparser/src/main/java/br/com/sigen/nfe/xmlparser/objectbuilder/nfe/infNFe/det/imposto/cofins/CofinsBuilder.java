package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.cofins;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.COFINS;

public class CofinsBuilder implements ObjectBuilder<COFINS> {

	@Override
	public COFINS build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();

		COFINS cofins = objectFactory.createTNFeInfNFeDetImpostoCOFINS();

//		cofins.setCOFINSAliq();
//		cofins.setCOFINSNT();
//		cofins.setCOFINSOutr();
//		cofins.setCOFINSQtde();

		return cofins;
	}

}
