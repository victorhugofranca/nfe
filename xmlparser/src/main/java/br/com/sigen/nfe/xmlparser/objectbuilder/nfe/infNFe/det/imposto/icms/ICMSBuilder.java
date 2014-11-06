package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.icms;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.icms.icms00.Icms00Builder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.ICMS;

public class ICMSBuilder implements ObjectBuilder<ICMS> {

	private Icms00Builder icms00Builder;

	@Override
	public ICMS build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		ICMS icms = objectFactory.createTNFeInfNFeDetImpostoICMS();
		icms.setICMS00(icms00Builder.build(map));
		
		return icms;
	}

	public void setIcms00Builder(Icms00Builder icms00Builder) {
		this.icms00Builder = icms00Builder;
	}
}
