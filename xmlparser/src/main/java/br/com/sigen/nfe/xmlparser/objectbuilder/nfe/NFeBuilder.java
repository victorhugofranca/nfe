package br.com.sigen.nfe.xmlparser.objectbuilder.nfe;

import java.util.Map;

import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.ObjectBuilderException;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe.InfNFeBuilder;
import br.com.sigen.nfe.xmlparser.objectbuilder.nfe.signature.SignatureBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe;
import br.inf.portalfiscal.nfe.TNFe.InfNFe;

public class NFeBuilder implements ObjectBuilder<TNFe> {

	private InfNFeBuilder infNFeBuilder;
	private SignatureBuilder signatureBuilder;

	@Override
	public TNFe build(Map<String, Object> map) throws ObjectBuilderException {
		ObjectFactory objectFactory = new ObjectFactory();

		TNFe tnFe = objectFactory.createTNFe();

		InfNFe infNFe = infNFeBuilder.build(map);

		tnFe.setInfNFe(infNFe);
		tnFe.setSignature(signatureBuilder.build(map));

		return tnFe;
	}

	public void setSignatureBuilder(SignatureBuilder signatureBuilder) {
		this.signatureBuilder = signatureBuilder;
	}

	public void setInfNFeBuilder(InfNFeBuilder infNFeBuilder) {
		this.infNFeBuilder = infNFeBuilder;
	}

}
