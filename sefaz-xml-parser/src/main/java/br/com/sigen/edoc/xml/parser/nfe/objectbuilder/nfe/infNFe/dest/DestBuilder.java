package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.dest;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TEndereco;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Dest;
import br.inf.portalfiscal.nfe.TUf;

public class DestBuilder implements ObjectBuilder<Dest> {

	@Override
	public Dest build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		Dest dest = objectFactory.createTNFeInfNFeDest();

//		NfeDataPool nfeDataPool = NfeDataPool.instance();
		//		try {
			// TODO VERIFICAR SE É PESSOA FÍSICA OU JURÍDICA PARA PREENCHER UM
			// DOS DOIS SEGUINTES CAMPOS
			// dest.setCNPJ(String.valueOf(map.get("destinatario_cpf_cnpj"));
			dest.setCPF(String.valueOf(map.get("destinatario_cpf_cnpj")));

			dest.setEmail(String.valueOf(map.get("destinatario_email")));

			TEndereco tEndereco = objectFactory.createTEndereco();
			tEndereco.setNro(String.valueOf(map.get("destinatario_numero")));
			tEndereco
					.setXLgr(String.valueOf(map.get("destinatario_logradouro")));
			tEndereco.setXBairro(String.valueOf(map.get("destinatario_bairro")));
			tEndereco.setCMun(String.valueOf(map.get("destinatario_cod_mun")));
			tEndereco.setXMun(String.valueOf(map.get("destinatario_municipio")));
			tEndereco.setUF(TUf.fromValue(String.valueOf(map.get("destinatario_uf"))));
			tEndereco.setCEP(String.valueOf(map.get("destinatario_cep")));
			tEndereco.setFone(String.valueOf(map.get("destinatario_fone")));
			// tEndereco.setCPais(String.valueOf(map.get("destinatario_email")));
			// tEndereco.setXPais(String.valueOf(map.get("destinatario_email")));
			// tEndereco.setXCpl(String.valueOf(map.get("destinatario_email")));

			dest.setEnderDest(tEndereco);
			// dest.setIdEstrangeiro(nfeDataPool.value("1",
			// "destinatario_cpf_cnpj")));
			
			//TODO PREENCHER DE ACORDO COM REGRA DE ISENTO/NÃO ISENTO/CONSUMIDOR
//			dest.setIE(String.valueOf(map.get("destinatario_ie")));
			
			// dest.setIM(String.valueOf(map.get("destinatario_cpf_cnpj")));

			// TODO parametrize
			dest.setIndIEDest("2");
			
			// dest.setISUF(String.valueOf(map.get("destinatario_cpf_cnpj")));
			dest.setXNome(String.valueOf(map.get("destinatario_razao_social")));

			
			
//
//			// TODO VERIFICAR SE É PESSOA FÍSICA OU JURÍDICA PARA PREENCHER UM
//			// DOS DOIS SEGUINTES CAMPOS
//			// dest.setCNPJ(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
//			dest.setCPF(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
//
//			dest.setEmail(nfeDataPool.value("1", "destinatario_email"));
//
//			TEndereco tEndereco = objectFactory.createTEndereco();
//			tEndereco.setNro(nfeDataPool.value("1", "destinatario_numero"));
//			tEndereco
//					.setXLgr(nfeDataPool.value("1", "destinatario_logradouro"));
//			tEndereco.setXBairro(nfeDataPool.value("1", "destinatario_bairro"));
//			tEndereco.setCMun(nfeDataPool.value("1", "destinatario_cod_mun"));
//			tEndereco.setXMun(nfeDataPool.value("1", "destinatario_municipio"));
//			tEndereco.setUF(TUf.fromValue(nfeDataPool.value("1",
//					"destinatario_uf")));
//			tEndereco.setCEP(nfeDataPool.value("1", "destinatario_cep"));
//			tEndereco.setFone(nfeDataPool.value("1", "destinatario_fone"));
//			// tEndereco.setCPais(nfeDataPool.value("1", "destinatario_email"));
//			// tEndereco.setXPais(nfeDataPool.value("1", "destinatario_email"));
//			// tEndereco.setXCpl(nfeDataPool.value("1", "destinatario_email"));
//
//			dest.setEnderDest(tEndereco);
//			// dest.setIdEstrangeiro(nfeDataPool.value("1",
//			// "destinatario_cpf_cnpj"));
//			
//			//TODO PREENCHER DE ACORDO COM REGRA DE ISENTO/NÃO ISENTO/CONSUMIDOR
////			dest.setIE(nfeDataPool.value("1", "destinatario_ie"));
//			
//			// dest.setIM(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
//
//			// TODO parametrize
//			dest.setIndIEDest("2");
//			
//			// dest.setISUF(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
//			dest.setXNome(nfeDataPool.value("1", "destinatario_razao_social"));

//		} catch (NfeDataNotFoundException e) {
//			e.printStackTrace();
//		}

		return dest;
	}
}
