package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.cobr;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.cobr.dup.DupBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.cobr.fat.FatBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Cobr;

public class CobrBuilder implements ObjectBuilder<Cobr> {

	private FatBuilder fatBuilder;
	private DupBuilder dupBuilder;

	@Override
	public Cobr build(Map<String, Object> map) throws ObjectBuilderException {
		Cobr cobr = new ObjectFactory().createTNFeInfNFeCobr();

//		for (int i = 0; i < 4; i++) {
//			cobr.getDup().add(dupBuilder.build());
//		}

		return cobr;
	}

	public void setFatBuilder(FatBuilder fatBuilder) {
		this.fatBuilder = fatBuilder;
	}

	public void setDupBuilder(DupBuilder dupBuilder) {
		this.dupBuilder = dupBuilder;
	}

}
