package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.envinfe;

import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.Config;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.NFeBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TEnviNFe;

public class EnviNFeBuilder implements ObjectBuilder<TEnviNFe> {

	private NFeBuilder nfeBuilder;

	@Override
	public TEnviNFe build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();

		TEnviNFe tEnviNFe = objectFactory.createTEnviNFe();
		tEnviNFe.setVersao(Config.VERSAO);
		tEnviNFe.setIdLote("1");
		tEnviNFe.setIndSinc(Config.PROCESSAMENTO_SINCRONO);

		tEnviNFe.getNFe().add(nfeBuilder.build(map));

		return tEnviNFe;
	}

	public void setNfeBuilder(NFeBuilder nfeBuilder) {
		this.nfeBuilder = nfeBuilder;
	}

}
