package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.cofins.CofinsBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.cofinsst.CofinsSTBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.icms.ICMSBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.ii.IIBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.ipi.IPIBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.issqn.ISSQNBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pis.PISBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.pisst.PISSTBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto;

public class ImpostoBuilder implements ObjectBuilder<Imposto> {

	private CofinsBuilder cofinsBuilder;
	private CofinsSTBuilder cofinSTBuilder;
	private ICMSBuilder icmsBuilder;
	private IIBuilder iiBuilder;
	private IPIBuilder ipiBuilder;
	private ISSQNBuilder issqnBuilder;
	private PISBuilder pisBuilder;
	private PISSTBuilder pisSTBuilder;

	@Override
	public Imposto build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();

		Imposto imposto = objectFactory.createTNFeInfNFeDetImposto();
//		imposto.getContent().add(
//				objectFactory.createTNFeInfNFeDetImpostoCOFINS(cofinsBuilder
//						.build(map)));
//		imposto.getContent().add(
//				objectFactory.createTNFeInfNFeDetImpostoCOFINSST(cofinSTBuilder
//						.build(map)));
		imposto.getContent().add(
				objectFactory.createTNFeInfNFeDetImpostoICMS(icmsBuilder
						.build(map)));
//		imposto.getContent()
//				.add(objectFactory.createTNFeInfNFeDetImpostoII(iiBuilder
//						.build(map)));
//		imposto.getContent().add(
//				objectFactory.createTNFeInfNFeDetImpostoIPI(ipiBuilder
//						.build(map)));
//		imposto.getContent().add(
//				objectFactory.createTNFeInfNFeDetImpostoISSQN(issqnBuilder
//						.build(map)));
//		imposto.getContent().add(
//				objectFactory.createTNFeInfNFeDetImpostoPIS(pisBuilder
//						.build(map)));
//		imposto.getContent().add(
//				objectFactory.createTNFeInfNFeDetImpostoPISST(pisSTBuilder
//						.build(map)));

		return imposto;
	}

	public void setCofinSTBuilder(CofinsSTBuilder cofinSTBuilder) {
		this.cofinSTBuilder = cofinSTBuilder;
	}

	public void setIcmsBuilder(ICMSBuilder icmsBuilder) {
		this.icmsBuilder = icmsBuilder;
	}

	public void setIiBuilder(IIBuilder iiBuilder) {
		this.iiBuilder = iiBuilder;
	}

	public void setIssqnBuilder(ISSQNBuilder issqnBuilder) {
		this.issqnBuilder = issqnBuilder;
	}

	public void setPisBuilder(PISBuilder pisBuilder) {
		this.pisBuilder = pisBuilder;
	}

	public void setPisSTBuilder(PISSTBuilder pisSTBuilder) {
		this.pisSTBuilder = pisSTBuilder;
	}

	public void setIpiBuilder(IPIBuilder ipiBuilder) {
		this.ipiBuilder = ipiBuilder;
	}

	public void setCofinsBuilder(CofinsBuilder cofinsBuilder) {
		this.cofinsBuilder = cofinsBuilder;
	}
}
