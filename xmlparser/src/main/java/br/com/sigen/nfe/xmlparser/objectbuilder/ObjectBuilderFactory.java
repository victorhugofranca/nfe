package br.com.sigen.nfe.xmlparser.objectbuilder;

import br.com.sigen.nfe.xmlparser.objectbuilder.envinfe.EnviNFeBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.NFeBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.InfNFeBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.cobr.CobrBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.cobr.dup.DupBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.cobr.fat.FatBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.dest.DestBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.DetBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.ImpostoBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.cofins.CofinsBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.cofinsst.CofinsSTBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.icms.ICMSBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.icms.icms00.Icms00Builder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.ii.IIBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.ipi.IPIBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.issqn.ISSQNBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pis.PISBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pis.pisaliq.PisAliqBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pis.pisnt.PisNTBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pis.pisoutr.PisOutrBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pis.pisqtde.PisQtdeBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.pisst.PISSTBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.ProdBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.arma.ArmaBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.comb.CombBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.di.DIBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.di.adi.AdiBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.med.MedBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.veicProd.VeicProdBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.emit.EmitBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.ide.IdeBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.total.TotalBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.total.icmstot.IcmsTotBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.transp.TranspBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.transp.transportadora.TransportadoraBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.signature.SignatureBuilder;

public class ObjectBuilderFactory extends ObjectBuilderAbstractFactory {
	
	@Override
	public ObjectBuilder createEnviNFeBuilder() {
		EnviNFeBuilder enviNFeBuilder = new EnviNFeBuilder();
		
		enviNFeBuilder.setNfeBuilder(createNFeBuilder());
		
		return enviNFeBuilder;
	}

	@Override
	public NFeBuilder createNFeBuilder() {

		NFeBuilder nFeBuilder = new NFeBuilder();

		nFeBuilder.setInfNFeBuilder(createInfNFeBuilder());
		nFeBuilder.setSignatureBuilder(createNfeSignatureBuilder());

		return nFeBuilder;
	}

	@Override
	public InfNFeBuilder createInfNFeBuilder() {
		InfNFeBuilder infNFeBuilder = new InfNFeBuilder();

		infNFeBuilder.setCobrBuilder(createInfNFeCobrBuilder());
		infNFeBuilder.setDestBuilder(createInfNFeDestBuilder());
		infNFeBuilder.setEmitBuilder(createInfNfeEmitBuilder());
		infNFeBuilder.setIdeBuilder(createInfNfeIdeBuilder());
		infNFeBuilder.setTotalBuilder(createInfNfeTotalBuilder());
		infNFeBuilder.setTranspBuilder(createInfNfeTranspBuilder());
		infNFeBuilder.setDetBuilder(createInfNfeDetBuilder());

		return infNFeBuilder;
	}

	@Override
	public CobrBuilder createInfNFeCobrBuilder() {
		CobrBuilder cobrBuilder = new CobrBuilder();
		cobrBuilder.setFatBuilder(createInfNFeCobrFatBuilder());
		cobrBuilder.setDupBuilder(createInfNFeCobrDupBuilder());
		return cobrBuilder;
	}

	@Override
	public FatBuilder createInfNFeCobrFatBuilder() {
		return new FatBuilder();
	}

	@Override
	public DupBuilder createInfNFeCobrDupBuilder() {
		return new DupBuilder();
	}

	@Override
	public DestBuilder createInfNFeDestBuilder() {
		return new DestBuilder();
	}

	@Override
	public DetBuilder createInfNfeDetBuilder() {
		DetBuilder detBuilder = new DetBuilder();
		detBuilder.setImpostoBuilder(createInfNfeDetImpostoBuilder());
		detBuilder.setProdBuilder(createInfNfeDetProdBuilder());
		return detBuilder;
	}

	@Override
	public ImpostoBuilder createInfNfeDetImpostoBuilder() {
		ImpostoBuilder impostoBuilder = new ImpostoBuilder();

		impostoBuilder.setCofinsBuilder(createInfNfeDetImpostoCofinsBuilder());
		impostoBuilder
				.setCofinSTBuilder(createInfNfeDetImpostoCofinsSTBuilder());
		impostoBuilder.setIcmsBuilder(createInfNfeDetImpostoIcmsBuilder());
		impostoBuilder.setIiBuilder(createInfNfeDetImpostoIIBuilder());
		impostoBuilder.setIpiBuilder(createInfNfeDetImpostoIPIBuilder());
		impostoBuilder.setIssqnBuilder(createInfNfeDetImpostoISSQNBuilder());
		impostoBuilder.setPisBuilder(createInfNfeDetImpostoPISBuilder());
		impostoBuilder.setPisSTBuilder(createInfNfeDetImpostoPisSTBuilder());

		return impostoBuilder;
	}

	@Override
	public ProdBuilder createInfNfeDetProdBuilder() {
		ProdBuilder prodBuilder = new ProdBuilder();

		prodBuilder.setArmaBuilder(createInfNfeDetProdArmaBuilder());
		prodBuilder.setCombBuilder(createInfNfeDetProdCombBuilder());
		prodBuilder.setDiBuilder(createInfNfeDetProdDiBuilder());
		prodBuilder.setMedBuilder(createInfNfeDetProdMedBuilder());
		prodBuilder.setVeicProdBuilder(createInfNfeDetProdVeicProdBuilder());

		return prodBuilder;
	}

	@Override
	public EmitBuilder createInfNfeEmitBuilder() {
		return new EmitBuilder();
	}

	@Override
	public IdeBuilder createInfNfeIdeBuilder() {
		return new IdeBuilder();
	}

	@Override
	public TotalBuilder createInfNfeTotalBuilder() {
		TotalBuilder totalBuilder = new TotalBuilder();
		totalBuilder.setIcmsTotBuilder(createInfNfeTotalIcmsTotBuilder());
		return totalBuilder;
	}

	@Override
	public TranspBuilder createInfNfeTranspBuilder() {
		TranspBuilder transpBuilder = new TranspBuilder();
		transpBuilder
				.setTransportadoraBuilder(createInfNfeTranspTransportadoraBuilder());
		return transpBuilder;
	}

	@Override
	public SignatureBuilder createNfeSignatureBuilder() {
		return new SignatureBuilder();
	}

	@Override
	public CofinsBuilder createInfNfeDetImpostoCofinsBuilder() {
		return new CofinsBuilder();
	}

	@Override
	public CofinsSTBuilder createInfNfeDetImpostoCofinsSTBuilder() {
		return new CofinsSTBuilder();
	}

	@Override
	public ICMSBuilder createInfNfeDetImpostoIcmsBuilder() {
		ICMSBuilder icmsBuilder = new ICMSBuilder();

		icmsBuilder.setIcms00Builder(createInfNfeDetImpostoIcmsIcms00Builder());

		return icmsBuilder;
	}

	@Override
	public Icms00Builder createInfNfeDetImpostoIcmsIcms00Builder() {
		return new Icms00Builder();
	}

	@Override
	public IIBuilder createInfNfeDetImpostoIIBuilder() {
		return new IIBuilder();
	}

	@Override
	public IPIBuilder createInfNfeDetImpostoIPIBuilder() {
		return new IPIBuilder();
	}

	@Override
	public ISSQNBuilder createInfNfeDetImpostoISSQNBuilder() {
		return new ISSQNBuilder();
	}

	@Override
	public PISBuilder createInfNfeDetImpostoPISBuilder() {
		PISBuilder pisBuilder = new PISBuilder();

		pisBuilder.setPisAliqBuilder(createInfNfeDetImpostoPISPisAliqBuilder());
		pisBuilder.setPisNTBuilder(createInfNfeDetImpostoPISPisNTBuilder());
		pisBuilder.setPisOutrBuilder(createInfNfeDetImpostoPISPisOutrBuilder());
		pisBuilder.setPisQtdeBuilder(createInfNfeDetImpostoPISPisQtdeBuilder());

		return pisBuilder;
	}

	@Override
	public PISSTBuilder createInfNfeDetImpostoPisSTBuilder() {
		return new PISSTBuilder();
	}

	@Override
	public ArmaBuilder createInfNfeDetProdArmaBuilder() {
		return new ArmaBuilder();
	}

	@Override
	public CombBuilder createInfNfeDetProdCombBuilder() {
		return new CombBuilder();
	}

	@Override
	public DIBuilder createInfNfeDetProdDiBuilder() {
		return new DIBuilder();
	}

	@Override
	public AdiBuilder createInfNfeDetProdDiAdiBuilder() {
		return new AdiBuilder();
	}

	@Override
	public MedBuilder createInfNfeDetProdMedBuilder() {
		return new MedBuilder();
	}

	@Override
	public VeicProdBuilder createInfNfeDetProdVeicProdBuilder() {
		return new VeicProdBuilder();
	}

	@Override
	public IcmsTotBuilder createInfNfeTotalIcmsTotBuilder() {
		return new IcmsTotBuilder();
	}

	@Override
	public TransportadoraBuilder createInfNfeTranspTransportadoraBuilder() {
		return new TransportadoraBuilder();
	}

	@Override
	public PisAliqBuilder createInfNfeDetImpostoPISPisAliqBuilder() {
		return new PisAliqBuilder();
	}

	@Override
	public PisNTBuilder createInfNfeDetImpostoPISPisNTBuilder() {
		return new PisNTBuilder();
	}

	@Override
	public PisOutrBuilder createInfNfeDetImpostoPISPisOutrBuilder() {
		return new PisOutrBuilder();
	}

	@Override
	public PisQtdeBuilder createInfNfeDetImpostoPISPisQtdeBuilder() {
		return new PisQtdeBuilder();
	}

}
