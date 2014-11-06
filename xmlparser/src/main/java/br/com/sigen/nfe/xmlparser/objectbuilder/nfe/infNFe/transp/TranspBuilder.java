package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.transp;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.transp.transportadora.TransportadoraBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Transp;

public class TranspBuilder implements ObjectBuilder<Transp> {

	private TransportadoraBuilder transportadoraBuilder;

	@Override
	public Transp build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();
		Transp transp = objectFactory.createTNFeInfNFeTransp();
		
		transp.setTransporta(transportadoraBuilder.build(map));

		// transp.setAvulsa(Avulsa);
		// transp.setCana(Cana);
		// transp.setCobr(Cobr);
		// transp.setCompra(Compra);
		// transp.setDest(Dest);
		// transp.setEmit(Emit);
		// transp.setEntrega(TLocal);
		// transp.setExporta(Exporta);
		// transp.setId(String);
		// transp.setIde(Ide);
		// transp.setInfAdic(InfAdic);
		// transp.setRetirada(TLocal);
		// transp.setTotal(Total);

		// transp.setVersao(String);

		return transp;
	}

	public void setTransportadoraBuilder(
			TransportadoraBuilder transportadoraBuilder) {
		this.transportadoraBuilder = transportadoraBuilder;
	}

}
