package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.total;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.total.icmstot.IcmsTotBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Total;

public class TotalBuilder implements ObjectBuilder<Total> {

	private IcmsTotBuilder icmsTotBuilder;

	@Override
	public Total build(Map<String, Object> map) throws ObjectBuilderException {
		Total total = new ObjectFactory().createTNFeInfNFeTotal();
		total.setICMSTot(icmsTotBuilder.build(map));
		return total;
	}

	public void setIcmsTotBuilder(IcmsTotBuilder icmsTotBuilder) {
		this.icmsTotBuilder = icmsTotBuilder;
	}

}
