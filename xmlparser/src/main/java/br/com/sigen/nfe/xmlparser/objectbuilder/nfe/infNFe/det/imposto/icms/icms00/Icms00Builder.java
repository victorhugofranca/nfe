package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.det.imposto.icms.icms00;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.NfeDataNotFoundException;
import br.com.sigen.nfe.xmlparser.NfeDataPool;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.ICMS.ICMS00;

public class Icms00Builder implements ObjectBuilder<ICMS00> {

	@Override
	public ICMS00 build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		
		ICMS00 icms00 = objectFactory.createTNFeInfNFeDetImpostoICMSICMS00();

//		NfeDataPool nfeDataPool = NfeDataPool.instance();
		try {
			icms00.setCST(nfeDataPool.value("1", "icms_situacao_tributaria"));
			icms00.setModBC(nfeDataPool.value("1",
					"icms_modalidade_determinacao_bc"));
			icms00.setOrig(nfeDataPool.value("1", "icms_origem"));

			icms00.setPICMS(nfeDataPool.value("1", "icms_aliquota"));
			icms00.setVBC(nfeDataPool.value("1", "icms_valor_bc"));
			icms00.setVICMS(nfeDataPool.value("1", "icms_valor"));

		} catch (NfeDataNotFoundException e) {
			e.printStackTrace();
		}

		return icms00;
	}

}
