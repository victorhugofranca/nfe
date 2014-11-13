package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.cofins;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
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
