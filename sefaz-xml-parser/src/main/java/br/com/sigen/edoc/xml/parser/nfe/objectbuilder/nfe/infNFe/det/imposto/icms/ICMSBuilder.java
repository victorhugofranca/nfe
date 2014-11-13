package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.icms;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.icms.icms00.Icms00Builder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.icms.icms60.Icms60Builder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.ICMS;

public class ICMSBuilder implements ObjectBuilder<ICMS> {

	private Icms00Builder icms00Builder;
	private Icms60Builder icms60Builder;

	@Override
	public ICMS build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();

		ICMS icms = objectFactory.createTNFeInfNFeDetImpostoICMS();

		// TODO PARAMETRIZAR VALORES DO CST NESTES TESTES
		if (String.valueOf(map.get("icms_situacao_tributaria")).equals("00")) {
			icms.setICMS00(icms00Builder.build(map));
		} else {
			icms.setICMS60(icms60Builder.build(map));
		}

		return icms;
	}

	public void setIcms00Builder(Icms00Builder icms00Builder) {
		this.icms00Builder = icms00Builder;
	}

	public void setIcms60Builder(Icms60Builder icms60Builder) {
		this.icms60Builder = icms60Builder;
	}
}
