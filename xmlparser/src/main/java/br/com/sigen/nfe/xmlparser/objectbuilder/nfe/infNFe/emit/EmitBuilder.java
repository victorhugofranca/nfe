package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.emit;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.NfeDataNotFoundException;
import br.com.sigen.nfe.xmlparser.NfeDataPool;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TEnderEmi;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Emit;
import br.inf.portalfiscal.nfe.TUfEmi;

public class EmitBuilder implements ObjectBuilder<Emit> {

	@Override
	public Emit build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		Emit emit = objectFactory.createTNFeInfNFeEmit();

//		NfeDataPool nfeDataPool = NfeDataPool.instance();

		try {
			// emit.setCNAE(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
			emit.setCNPJ(nfeDataPool.value("1", "emitente_cnpj"));
			// emit.setCPF(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
			emit.setCRT(nfeDataPool.value("1", "emitente_crt"));

			TEnderEmi tEndereco = objectFactory.createTEnderEmi();
			tEndereco.setNro(nfeDataPool.value("1", "emitente_numero"));
			tEndereco.setXLgr(nfeDataPool.value("1", "emitente_logradouro"));
			tEndereco.setXBairro(nfeDataPool.value("1", "emitente_bairro"));
			tEndereco.setCMun(nfeDataPool.value("1", "emitente_cod_mun"));
			tEndereco.setXMun(nfeDataPool.value("1", "emitente_municipio"));
			tEndereco.setUF(TUfEmi.fromValue(nfeDataPool.value("1",
					"emitente_uf")));
			tEndereco.setCEP(nfeDataPool.value("1", "emitente_cep"));
			tEndereco.setFone(nfeDataPool.value("1", "emitente_fone"));
			// tEndereco.setCPais(nfeDataPool.value("1", "destinatario_email"));
			// tEndereco.setXPais(nfeDataPool.value("1", "destinatario_email"));
			// tEndereco.setXCpl(nfeDataPool.value("1", "destinatario_email"));

			emit.setEnderEmit(tEndereco);

			emit.setIE(nfeDataPool.value("1", "emitente_ie"));
			// emit.setIEST(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
			// emit.setIM(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
			// emit.setXFant(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
			emit.setXNome(nfeDataPool.value("1", "emitente_razao_social"));

		} catch (NfeDataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emit;
	}

}
