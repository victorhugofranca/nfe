package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.cofins.cofinsliq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq;

public class CofinsAliqBuilder implements ObjectBuilder<COFINSAliq> {

	@Override
	public COFINSAliq build(Map<String, Object> map)
			throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		
		
		COFINSAliq cofinsAliq = objectFactory
				.createTNFeInfNFeDetImpostoCOFINSCOFINSAliq();

		cofinsAliq
				.setCST(String.valueOf(map.get("cofins_situacao_tributaria")));
		cofinsAliq.setPCOFINS(String.valueOf(map.get("cofins_aliquota")));
		cofinsAliq.setVBC(String.valueOf(map.get("cofins_valor_bc")));
		cofinsAliq.setVCOFINS(String.valueOf(map.get("cofins_valor")));

		return cofinsAliq;
	}

}
