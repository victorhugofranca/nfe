package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.cofins;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.cofins.cofinsliq.CofinsAliqBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.COFINS;

public class CofinsBuilder implements ObjectBuilder<COFINS> {

	private CofinsAliqBuilder cofinsAliqBuilder;

	@Override
	public COFINS build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();

		COFINS cofins = objectFactory.createTNFeInfNFeDetImpostoCOFINS();

		cofins.setCOFINSAliq(cofinsAliqBuilder.build(map));
		
		// cofins.setCOFINSNT();
		// cofins.setCOFINSOutr();
		// cofins.setCOFINSQtde();

		return cofins;
	}
	
	public void setCofinsAliqBuilder(CofinsAliqBuilder cofinsAliqBuilder) {
		this.cofinsAliqBuilder = cofinsAliqBuilder;
	}

}
