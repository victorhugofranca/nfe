package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis.pisaliq.PisAliqBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis.pisnt.PisNTBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis.pisoutr.PisOutrBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis.pisqtde.PisQtdeBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS;

public class PISBuilder implements ObjectBuilder<PIS> {

	private PisAliqBuilder pisAliqBuilder;

	private PisNTBuilder pisNTBuilder;

	private PisQtdeBuilder pisQtdeBuilder;

	private PisOutrBuilder pisOutrBuilder;

	@Override
	public PIS build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		PIS pis = objectFactory.createTNFeInfNFeDetImpostoPIS();

		pis.setPISAliq(pisAliqBuilder.build(map));

		// TODO: parametrize
		// pis.setPISNT(pisNTBuilder.build(map));
		// pis.setPISOutr(pisOutrBuilder.build(map));
		// pis.setPISQtde(pisQtdeBuilder.build(map));

		return pis;
	}

	public void setPisAliqBuilder(PisAliqBuilder pisAliqBuilder) {
		this.pisAliqBuilder = pisAliqBuilder;
	}

	public void setPisNTBuilder(PisNTBuilder pisNTBuilder) {
		this.pisNTBuilder = pisNTBuilder;
	}

	public void setPisOutrBuilder(PisOutrBuilder pisOutrBuilder) {
		this.pisOutrBuilder = pisOutrBuilder;
	}

	public void setPisQtdeBuilder(PisQtdeBuilder pisQtdeBuilder) {
		this.pisQtdeBuilder = pisQtdeBuilder;
	}

}
