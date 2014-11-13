package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.prod;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.prod.arma.ArmaBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.prod.comb.CombBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.prod.di.DIBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.prod.med.MedBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.prod.veicProd.VeicProdBuilder;
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

		prod.setCEAN(String.valueOf(map.get("ean")));
		prod.setCEANTrib(String.valueOf(map.get("ean_trib")));
		prod.setCFOP(String.valueOf(map.get("cfop")));

		prod.setCProd(String.valueOf(map.get("codigo")));

		// prod.setEXTIPI(String.valueOf(map.get("ean")));

		prod.setIndTot(String.valueOf(map.get("indicador_total")));
		prod.setNCM(String.valueOf(map.get("ncm")));

		// prod.setNFCI(String.valueOf(map.get("ean")));

		// prod.setNItemPed(String.valueOf(map.get("ean")));

		// prod.setNRECOPI(String.valueOf(map.get("ean")));

		prod.setQCom(String.valueOf(map.get("qtd_comercial")));
		prod.setQTrib(String.valueOf(map.get("qtd_trib")));
		prod.setUCom(String.valueOf(map.get("un_comercial")));
		prod.setUTrib(String.valueOf(map.get("und_trib")));

		// prod.setVDesc(String.valueOf(map.get("ean")));

		// prod.setVFrete(String.valueOf(map.get("ean")));
		// prod.setVOutro(String.valueOf(map.get("ean")));

		prod.setVProd(String.valueOf(map.get("valor_total_bruto")));
		// prod.setVSeg(String.valueOf(map.get("ean")));
		prod.setVUnCom(String.valueOf(map.get("valor_unit_comercial")));
		prod.setVUnTrib(String.valueOf(map.get("valor_unit_trib")));

		// prod.setXPed(String.valueOf(map.get("ean")));

		prod.setXProd(String.valueOf(map.get("descricao")));

		// prod.setComb(combBuilder.build(map));
		// prod.setVeicProd(veicProdBuilder.build(map));

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
