package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.transp.transportadora;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
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

		transporta.setCNPJ(String.valueOf(map.get("transp_cpf_cnpj")));
		// transporta.setCPF(String.valueOf(map.get("transp_cpf_cnpj"));
		transporta.setIE(String.valueOf(map.get("transp_ie")));

		Object ufObj = map.get("transp_uf");
		if (ufObj != null) {
			transporta.setUF(TUf.valueOf(String.valueOf(map.get("transp_uf"))));
		}

		transporta
				.setXEnder(String.valueOf(map.get("transp_endereco_completo")));
		transporta.setXMun(String.valueOf(map.get("transp_municipio")));
		transporta.setXNome(String.valueOf(map.get("transp_razao_social")));

		// NfeDataPool nfeDataPool = NfeDataPool.instance();

		// try {
		// transporta.setCNPJ(nfeDataPool.value("1", "transp_cpf_cnpj"));
		// // transporta.setCPF(nfeDataPool.value("1", "transp_cpf_cnpj"));
		// transporta.setIE(nfeDataPool.value("1", "transp_ie"));
		//
		// String uf = nfeDataPool.value("1", "transp_uf");
		// if (uf != null) {
		// transporta.setUF(TUf.valueOf(uf));
		// }
		//
		// transporta.setXEnder(nfeDataPool.value("1",
		// "transp_endereco_completo"));
		// transporta.setXMun(nfeDataPool.value("1", "transp_municipio"));
		// transporta.setXNome(nfeDataPool.value("1", "transp_razao_social"));
		//
		// } catch (NfeDataNotFoundException e) {
		// e.printStackTrace();
		// }

		return transporta;
	}

}
