package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.total.icmstot;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Total.ICMSTot;

public class IcmsTotBuilder implements ObjectBuilder<ICMSTot> {

	@Override
	public ICMSTot build(Map<String, Object> map) throws ObjectBuilderException {
		ICMSTot icmsTot = new ObjectFactory().createTNFeInfNFeTotalICMSTot();

		icmsTot.setVBC(String.valueOf(map.get("total_icms_bc")));
		icmsTot.setVBCST(String.valueOf(map.get("total_icms_bc_st")));
		icmsTot.setVCOFINS(String.valueOf(map.get("total_cofins")));
		icmsTot.setVDesc(String.valueOf(map.get("total_desconto")));
		icmsTot.setVFrete(String.valueOf(map.get("total_frete")));
		icmsTot.setVICMS(String.valueOf(map.get("total_icms_total")));
		
		//TODO checar esta informação
		icmsTot.setVICMSDeson("0.00");
		
		icmsTot.setVII(String.valueOf(map.get("total_ii")));
		icmsTot.setVIPI(String.valueOf(map.get("total_ipi")));
		icmsTot.setVNF(String.valueOf(map.get("total_nota")));
		icmsTot.setVOutro(String.valueOf(map.get("total_outros")));
		icmsTot.setVPIS(String.valueOf(map.get("total_pis")));
		icmsTot.setVProd(String.valueOf(map.get("total_produtos")));
		icmsTot.setVSeg(String.valueOf(map.get("total_seguro")));
		icmsTot.setVST(String.valueOf(map.get("total_icms_total_st")));
		// icmsTot.setVTotTrib(nfeDataPool.value("1",
		// "inf_nfe_cod_mun_fg"));

		// NfeDataPool nfeDataPool = NfeDataPool.instance();

		// try {
		// icmsTot.setVBC(nfeDataPool.value("1", "total_icms_bc"));
		// icmsTot.setVBCST(nfeDataPool.value("1", "total_icms_bc_st"));
		// icmsTot.setVCOFINS(nfeDataPool.value("1", "total_cofins"));
		// icmsTot.setVDesc(nfeDataPool.value("1", "total_desconto"));
		// icmsTot.setVFrete(nfeDataPool.value("1", "total_frete"));
		// icmsTot.setVICMS(nfeDataPool.value("1", "total_icms_total"));
		// // icmsTot.setVICMSDeson(nfeDataPool.value("1",
		// // "inf_nfe_cod_mun_fg"));
		// icmsTot.setVII(nfeDataPool.value("1", "total_ii"));
		// icmsTot.setVIPI(nfeDataPool.value("1", "total_ipi"));
		// icmsTot.setVNF(nfeDataPool.value("1", "total_nota"));
		// icmsTot.setVOutro(nfeDataPool.value("1", "total_outros"));
		// icmsTot.setVPIS(nfeDataPool.value("1", "total_pis"));
		// icmsTot.setVProd(nfeDataPool.value("1", "total_produtos"));
		// icmsTot.setVSeg(nfeDataPool.value("1", "total_seguro"));
		// icmsTot.setVST(nfeDataPool.value("1", "total_icms_total_st"));
		// // icmsTot.setVTotTrib(nfeDataPool.value("1",
		// // "inf_nfe_cod_mun_fg"));
		//
		// } catch (NfeDataNotFoundException e) {
		// e.printStackTrace();
		// }

		return icmsTot;
	}

}
