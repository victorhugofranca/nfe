package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.emit;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TEnderEmi;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Emit;
import br.inf.portalfiscal.nfe.TUfEmi;

public class EmitBuilder implements ObjectBuilder<Emit> {

	@Override
	public Emit build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		Emit emit = objectFactory.createTNFeInfNFeEmit();

		// emit.setCNAE(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		emit.setCNPJ(String.valueOf(map.get("emitente_cnpj")));
		// emit.setCPF(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		emit.setCRT(String.valueOf(map.get("emitente_crt")));

		TEnderEmi tEndereco = objectFactory.createTEnderEmi();
		tEndereco.setNro(String.valueOf(map.get("emitente_numero")));
		tEndereco.setXLgr(String.valueOf(map.get("emitente_logradouro")));
		tEndereco.setXBairro(String.valueOf(map.get("emitente_bairro")));
		tEndereco.setCMun(String.valueOf(map.get("emitente_cod_mun")));
		tEndereco.setXMun(String.valueOf(map.get("emitente_municipio")));
		tEndereco
				.setUF(TUfEmi.fromValue(String.valueOf(map.get("emitente_uf"))));
		tEndereco.setCEP(String.valueOf(map.get("emitente_cep")));
		tEndereco.setFone(String.valueOf(map.get("emitente_fone")));
		// tEndereco.setCPais(String.valueOf(map.get("destinatario_email"));
		// tEndereco.setXPais(String.valueOf(map.get("destinatario_email"));
		// tEndereco.setXCpl(String.valueOf(map.get("destinatario_email"));

		emit.setEnderEmit(tEndereco);

		emit.setIE(String.valueOf(map.get("emitente_ie")));
		// emit.setIEST(String.valueOf(map.get("destinatario_cpf_cnpj"));
		// emit.setIM(String.valueOf(map.get("destinatario_cpf_cnpj"));
		// emit.setXFant(String.valueOf(map.get("destinatario_cpf_cnpj"));
		emit.setXNome(String.valueOf(map.get("emitente_razao_social")));

		
		
		
		
		// NfeDataPool nfeDataPool = NfeDataPool.instance();

		// try {
		// // emit.setCNAE(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		// emit.setCNPJ(nfeDataPool.value("1", "emitente_cnpj"));
		// // emit.setCPF(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		// emit.setCRT(nfeDataPool.value("1", "emitente_crt"));
		//
		// TEnderEmi tEndereco = objectFactory.createTEnderEmi();
		// tEndereco.setNro(nfeDataPool.value("1", "emitente_numero"));
		// tEndereco.setXLgr(nfeDataPool.value("1", "emitente_logradouro"));
		// tEndereco.setXBairro(nfeDataPool.value("1", "emitente_bairro"));
		// tEndereco.setCMun(nfeDataPool.value("1", "emitente_cod_mun"));
		// tEndereco.setXMun(nfeDataPool.value("1", "emitente_municipio"));
		// tEndereco.setUF(TUfEmi.fromValue(nfeDataPool.value("1",
		// "emitente_uf")));
		// tEndereco.setCEP(nfeDataPool.value("1", "emitente_cep"));
		// tEndereco.setFone(nfeDataPool.value("1", "emitente_fone"));
		// // tEndereco.setCPais(nfeDataPool.value("1", "destinatario_email"));
		// // tEndereco.setXPais(nfeDataPool.value("1", "destinatario_email"));
		// // tEndereco.setXCpl(nfeDataPool.value("1", "destinatario_email"));
		//
		// emit.setEnderEmit(tEndereco);
		//
		// emit.setIE(nfeDataPool.value("1", "emitente_ie"));
		// // emit.setIEST(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		// // emit.setIM(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		// // emit.setXFant(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		// emit.setXNome(nfeDataPool.value("1", "emitente_razao_social"));
		//
		// } catch (NfeDataNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		return emit;
	}
}
