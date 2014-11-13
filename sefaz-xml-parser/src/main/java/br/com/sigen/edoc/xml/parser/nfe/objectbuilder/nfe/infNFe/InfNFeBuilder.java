package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe;

import java.text.ParseException;
import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.Config;
import br.com.sigen.edoc.xml.parser.nfe.DateHelper;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderExceptionType;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.cobr.CobrBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.dest.DestBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.DetBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.emit.EmitBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.ide.IdeBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.total.TotalBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.transp.TranspBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe;

public class InfNFeBuilder implements ObjectBuilder<InfNFe> {

	private CobrBuilder cobrBuilder;
	private DestBuilder destBuilder;
	private EmitBuilder emitBuilder;
	private IdeBuilder ideBuilder;
	private TotalBuilder totalBuilder;
	private TranspBuilder transpBuilder;
	private DetBuilder detBuilder;

	@Override
	public InfNFe build(Map<String, Object> map) throws ObjectBuilderException {

		ObjectFactory objectFactory = new ObjectFactory();
		InfNFe infNFe = objectFactory.createTNFeInfNFe();

		infNFe.setVersao(Config.VERSAO);

		// infNFe.setCobr(cobrBuilder.build());
		infNFe.setDest(destBuilder.build(map));
		infNFe.setEmit(emitBuilder.build(map));
		infNFe.setIde(ideBuilder.build(map));
		infNFe.setTotal(totalBuilder.build(map));
		infNFe.setTransp(transpBuilder.build(map));

		infNFe.getDet().addAll(detBuilder.build(map));

		try {
			infNFe.setId(new ChaveAcessoHelper(infNFe.getIde().getCUF(),
					DateHelper.strToStr(infNFe.getIde().getDhEmi(),
							"yyyy-MM-dd'T'HH:mm:ssXXX", "yyMM"), infNFe
							.getEmit().getCNPJ(), infNFe.getIde().getMod(),
					infNFe.getIde().getSerie(), infNFe.getIde().getNNF(),
					infNFe.getIde().getTpEmis(), infNFe.getIde().getCNF())
					.toString());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ObjectBuilderException(
					ObjectBuilderExceptionType.DATA_FORMATO_INVALIDO);
		}

		return infNFe;
	}

	public void setCobrBuilder(CobrBuilder cobrBuilder) {
		this.cobrBuilder = cobrBuilder;
	}

	public void setDestBuilder(DestBuilder destBuilder) {
		this.destBuilder = destBuilder;
	}

	public void setEmitBuilder(EmitBuilder emitBuilder) {
		this.emitBuilder = emitBuilder;
	}

	public void setIdeBuilder(IdeBuilder ideBuilder) {
		this.ideBuilder = ideBuilder;
	}

	public void setTotalBuilder(TotalBuilder totalBuilder) {
		this.totalBuilder = totalBuilder;
	}

	public void setTranspBuilder(TranspBuilder transpBuilder) {
		this.transpBuilder = transpBuilder;
	}

	public void setDetBuilder(DetBuilder detBuilder) {
		this.detBuilder = detBuilder;
	}

}
