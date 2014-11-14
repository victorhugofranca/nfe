package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis.pisaliq;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS.PISAliq;

public class PisAliqBuilder implements ObjectBuilder<PISAliq> {

	@Override
	public PISAliq build(Map<String, Object> map) throws ObjectBuilderException {
		PISAliq pisAliq = new ObjectFactory()
				.createTNFeInfNFeDetImpostoPISPISAliq();

		// TODO: parametrize
		pisAliq.setCST(String.valueOf(map.get("pis_situacao_tributaria")));
		pisAliq.setPPIS(String.valueOf(map.get("pis_aliquota")));
		pisAliq.setVBC(String.valueOf(map.get("pis_valor_bc")));
		pisAliq.setVPIS(String.valueOf(map.get("pis_valor")));
		
		return pisAliq;

	}
}
