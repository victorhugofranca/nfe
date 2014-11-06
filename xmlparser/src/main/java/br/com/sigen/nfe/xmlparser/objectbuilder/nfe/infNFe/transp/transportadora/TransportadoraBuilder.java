package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.transp.transportadora;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.NfeDataNotFoundException;
import br.com.sigen.nfe.xmlparser.NfeDataPool;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Transp.Transporta;
import br.inf.portalfiscal.nfe.TUf;

public class TransportadoraBuilder implements ObjectBuilder<Transporta> {

	@Override
	public Transporta build(Map<String, Object> map)
			throws ObjectBuilderException {
		TNFe.InfNFe.Transp.Transporta transporta = new ObjectFactory()
				.createTNFeInfNFeTranspTransporta();

		// NfeDataPool nfeDataPool = NfeDataPool.instance();

		try {
			transporta.setCNPJ(nfeDataPool.value("1", "transp_cpf_cnpj"));
			// transporta.setCPF(nfeDataPool.value("1", "transp_cpf_cnpj"));
			transporta.setIE(nfeDataPool.value("1", "transp_ie"));

			String uf = nfeDataPool.value("1", "transp_uf");
			if (uf != null) {
				transporta.setUF(TUf.valueOf(uf));
			}

			transporta.setXEnder(nfeDataPool.value("1",
					"transp_endereco_completo"));
			transporta.setXMun(nfeDataPool.value("1", "transp_municipio"));
			transporta.setXNome(nfeDataPool.value("1", "transp_razao_social"));

		} catch (NfeDataNotFoundException e) {
			e.printStackTrace();
		}

		return transporta;
	}

}
