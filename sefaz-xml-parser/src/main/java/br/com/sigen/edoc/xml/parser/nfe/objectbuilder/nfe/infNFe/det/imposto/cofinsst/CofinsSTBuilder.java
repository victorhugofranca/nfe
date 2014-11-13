package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.cofinsst;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.COFINSST;

public class CofinsSTBuilder implements ObjectBuilder<COFINSST> {

	@Override
	public COFINSST build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		COFINSST cofinsST = objectFactory.createTNFeInfNFeDetImpostoCOFINSST();
		
//		cofinsST.setPCOFINS(value);cofinsST.setQBCProd(value);
//		cofinsST.setVAliqProd(value);
//		cofinsST.setVBC(value);
//		cofinsST.setVCOFINS(value);
		
		return cofinsST;
	}

}
