package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.ide;

import java.text.ParseException;
import java.util.Map;
import java.util.Random;

import br.com.sigen.edoc.xml.parser.nfe.Config;
import br.com.sigen.edoc.xml.parser.nfe.DateHelper;
import br.com.sigen.edoc.xml.parser.nfe.NumberHelper;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderExceptionType;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.UfIBGE;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Ide;

public class IdeBuilder implements ObjectBuilder<Ide> {

	@Override
	public Ide build(Map<String, Object> map) throws ObjectBuilderException {

		ObjectFactory objectFactory = new ObjectFactory();
		Ide ide = objectFactory.createTNFeInfNFeIde();

		ide.setCMunFG(String.valueOf(map.get("inf_nfe_cod_mun_fg")));

		// TODO: Parametrize
		ide.setCNF(generateCNF(8));

		ide.setCUF(String.valueOf(UfIBGE.fromValue(
				String.valueOf(map.get("emitente_uf"))).getCodigoIBGE()));
		// ide.setDhCont(String.valueOf(map.get("destinatario_cpf_cnpj"));
		try {
			ide.setDhEmi(DateHelper.strToStr(
					String.valueOf(map.get("inf_nfe_data_emissao")),
					"dd/MM/yyyy", "yyyy-MM-dd'T'HH:mm:ssXXX"));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ObjectBuilderException(
					ObjectBuilderExceptionType.DATA_FORMATO_INVALIDO);
		}
		// ide.setDhSaiEnt(String.valueOf(map.get("destinatario_cpf_cnpj"));
		ide.setFinNFe(String.valueOf(map.get("inf_nfe_finalidade")));

		// TODO: Parametrize
		// 1=Operação interna;
		// 2=Operação interestadual;
		// 3=Operação com exterior.
		ide.setIdDest("2");

		// TODO: Parametrize
		// 0=Não;
		// 1=Consumidor final;
		ide.setIndFinal("0");

		ide.setIndPag(String.valueOf(map.get("inf_nfe_ind_pag")));

		// TODO: parametrize
		// 0=Não se aplica (por exemplo, Nota Fiscal complementar
		// ou de ajuste);
		// 1=Operação presencial;
		// 2=Operação não presencial, pela Internet;
		// 3=Operação não presencial, Teleatendimento;
		// 4=NFC-e em operação com entrega a domicílio;
		// 9=Operação não presencial, outros.
		ide.setIndPres("9");

		// TODO: Parametrize
		ide.setMod("55");

		ide.setNatOp(String.valueOf(map.get("inf_nfe_natureza_operacao")));
		ide.setNNF(String.valueOf(map.get("inf_nfe_numero")));

		// TODO: parametrize
		// 0=Emissão de NF-e com aplicativo do contribuinte;
		// 1=Emissão de NF-e avulsa pelo Fisco;
		// 2=Emissão de NF-e avulsa, pelo contribuinte com seu
		// certificado digital, através do site do Fisco;
		// 3=Emissão NF-e pelo contribuinte com aplicativo
		// fornecido pelo Fisco.
		ide.setProcEmi("0");

		ide.setSerie(NumberHelper.removeLeftZeros(String.valueOf(map
				.get("inf_nfe_serie"))));

		// TODO: parametrize
		ide.setTpAmb(Config.TP_AMB);

		ide.setTpEmis(String.valueOf(map.get("inf_nfe_tipo_emissao")));
		ide.setTpImp(String.valueOf(map.get("inf_nfe_tp_imp")));
		ide.setTpNF(String.valueOf(map.get("inf_nfe_tipo_nf")));

		// TODO: parametrize
		ide.setVerProc(Config.VER_PROC);

		// ide.setXJust(String.valueOf(map.get("destinatario_cpf_cnpj"));

		// NfeDataPool nfeDataPool = NfeDataPool.instance();

		// try {
		// // TODO: CARREGAR O DV DA CHAVE DE ACESSO
		// ide.setCDV("1");
		//
		// ide.setCMunFG(nfeDataPool.value("1", "inf_nfe_cod_mun_fg"));
		//
		// // TODO: Parametrize
		// ide.setCNF(generateCNF(8));
		//
		// ide.setCUF(String.valueOf(UfIBGE.fromValue(
		// nfeDataPool.value("1", "emitente_uf")).getCodigoIBGE()));
		// // ide.setDhCont(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		// try {
		// ide.setDhEmi(DateHelper.strToStr(
		// nfeDataPool.value("1", "inf_nfe_data_emissao"),
		// "dd/MM/yyyy", "yyyy-MM-dd'T'HH:mm:ssXXX"));
		// } catch (ParseException e) {
		// e.printStackTrace();
		// throw new ObjectBuilderException(
		// ObjectBuilderExceptionType.DATA_FORMATO_INVALIDO);
		// }
		// // ide.setDhSaiEnt(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		// ide.setFinNFe(nfeDataPool.value("1", "inf_nfe_finalidade"));
		//
		// // TODO: Parametrize
		// // 1=Operação interna;
		// // 2=Operação interestadual;
		// // 3=Operação com exterior.
		// ide.setIdDest("1");
		//
		// // TODO: Parametrize
		// // 0=Não;
		// // 1=Consumidor final;
		// ide.setIndFinal("0");
		//
		// ide.setIndPag(nfeDataPool.value("1", "inf_nfe_ind_pag"));
		//
		// // TODO: parametrize
		// // 0=Não se aplica (por exemplo, Nota Fiscal complementar
		// // ou de ajuste);
		// // 1=Operação presencial;
		// // 2=Operação não presencial, pela Internet;
		// // 3=Operação não presencial, Teleatendimento;
		// // 4=NFC-e em operação com entrega a domicílio;
		// // 9=Operação não presencial, outros.
		// ide.setIndPres("9");
		//
		// // TODO: Parametrize
		// ide.setMod("55");
		//
		// ide.setNatOp(nfeDataPool.value("1", "inf_nfe_natureza_operacao"));
		// ide.setNNF(nfeDataPool.value("1", "inf_nfe_numero"));
		//
		// // TODO: parametrize
		// // 0=Emissão de NF-e com aplicativo do contribuinte;
		// // 1=Emissão de NF-e avulsa pelo Fisco;
		// // 2=Emissão de NF-e avulsa, pelo contribuinte com seu
		// // certificado digital, através do site do Fisco;
		// // 3=Emissão NF-e pelo contribuinte com aplicativo
		// // fornecido pelo Fisco.
		// ide.setProcEmi("0");
		//
		// ide.setSerie(NumberHelper.removeLeftZeros(nfeDataPool.value("1",
		// "inf_nfe_serie")));
		//
		// // TODO: parametrize
		// ide.setTpAmb(Config.TP_AMB);
		//
		// ide.setTpEmis(nfeDataPool.value("1", "inf_nfe_tipo_emissao"));
		// ide.setTpImp(nfeDataPool.value("1", "inf_nfe_tp_imp"));
		// ide.setTpNF(nfeDataPool.value("1", "inf_nfe_tipo_nf"));
		//
		// // TODO: parametrize
		// ide.setVerProc(Config.VER_PROC);
		//
		// // ide.setXJust(nfeDataPool.value("1", "destinatario_cpf_cnpj"));
		//
		// } catch (NfeDataNotFoundException e) {
		// e.printStackTrace();
		// }

		return ide;
	}

	private String generateCNF(int size) {

		Random random = new Random();

		String retorno = "";
		for (int i = 0; i < size; i++)
			retorno += random.nextInt(9);

		return retorno;
	}
}
