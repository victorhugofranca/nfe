package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.arma.ArmaBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.comb.CombBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.di.DIBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.med.MedBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.prod.veicProd.VeicProdBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod;

public class ProdBuilder implements ObjectBuilder<Prod> {

	private ArmaBuilder armaBuilder;
	private CombBuilder combBuilder;
	private DIBuilder diBuilder;
	private MedBuilder medBuilder;
	private VeicProdBuilder veicProdBuilder;

	@Override
	public Prod build(Map<String, Object> map) throws ObjectBuilderException {
		
		ObjectFactory objectFactory = new ObjectFactory();
		Prod prod = objectFactory.createTNFeInfNFeDetProd();
		
		prod.setCProd(value);
		
//		NfeDataPool nfeDataPool = NfeDataPool.instance();
		
		prod.setComb(combBuilder.build(map));
		prod.setVeicProd(veicProdBuilder.build(map));

		return prod;
	}

	public void setArmaBuilder(ArmaBuilder armaBuilder) {
		this.armaBuilder = armaBuilder;
	}

	public void setCombBuilder(CombBuilder combBuilder) {
		this.combBuilder = combBuilder;
	}

	public void setDiBuilder(DIBuilder diBuilder) {
		this.diBuilder = diBuilder;
	}

	public void setMedBuilder(MedBuilder medBuilder) {
		this.medBuilder = medBuilder;
	}

	public void setVeicProdBuilder(VeicProdBuilder veicProdBuilder) {
		this.veicProdBuilder = veicProdBuilder;
	}

}
