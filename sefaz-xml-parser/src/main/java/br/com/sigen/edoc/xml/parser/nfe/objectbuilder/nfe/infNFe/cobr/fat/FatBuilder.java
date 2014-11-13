package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.cobr.fat;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Cobr.Fat;

public class FatBuilder implements ObjectBuilder<Fat> {

	@Override
	public Fat build(Map<String, Object> map) throws ObjectBuilderException {
		Fat fat = new ObjectFactory().createTNFeInfNFeCobrFat();
		
//		fat.setNFat(value);
//		fat.setVDesc(value);
//		fat.setVLiq(value);
//		fat.setVOrig(value);
		
		return fat;
	}

}
