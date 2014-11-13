package br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.imposto.ImpostoBuilder;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.nfe.infNFe.det.prod.ProdBuilder;
import br.inf.portalfiscal.nfe.ObjectFactory;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det;

public class DetBuilder implements ObjectBuilder<List<Det>> {

	private ImpostoBuilder impostoBuilder;
	private ProdBuilder prodBuilder;

	@Override
	public List<Det> build(Map<String, Object> map)
			throws ObjectBuilderException {

		ObjectFactory objectFactory = new ObjectFactory();

		List<Det> dets = new LinkedList<Det>();

		Iterator<Map<String, Object>> itensIterator = ((List) map.get("itens"))
				.iterator();

		int i = 1;
		while (itensIterator.hasNext()) {
			Map<String, Object> itemMap = (Map<String, Object>) itensIterator
					.next();
			Det det = objectFactory.createTNFeInfNFeDet();

			// TODO preencher com chave unica do item(pode vim do erp)
			det.setNItem(String.valueOf(i++));

			det.setImposto(impostoBuilder.build(itemMap));
			det.setProd(prodBuilder.build(itemMap));

			dets.add(det);

		}

		//
		// // NfeDataPool nfeDataPool = NfeDataPool.instance();
		// for (int i = 0; i < nfeDataPool.itensSize("1"); i++) {
		// Det det = objectFactory.createTNFeInfNFeDet();
		//
		// // TODO preencher com chave unica do item(pode vim do erp)
		// det.setNItem(String.valueOf(i + 1));
		//
		// det.setImposto(impostoBuilder.build(map));
		// det.setProd(prodBuilder.build(map));
		//
		// dets.add(det);
		// }

		return dets;
	}

	public void setImpostoBuilder(ImpostoBuilder impostoBuilder) {
		this.impostoBuilder = impostoBuilder;
	}

	public void setProdBuilder(ProdBuilder prodBuilder) {
		this.prodBuilder = prodBuilder;
	}

}
