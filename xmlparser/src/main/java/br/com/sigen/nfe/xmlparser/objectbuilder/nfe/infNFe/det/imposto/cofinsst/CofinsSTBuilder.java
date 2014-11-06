package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.cofinsst;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
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
