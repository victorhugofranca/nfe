package br.com.sigen.nfe.xmlparser.objectbuilder;

public abstract class ObjectBuilderAbstractFactory {
	
	public abstract ObjectBuilder createEnviNFeBuilder();

	public abstract ObjectBuilder createNFeBuilder();

	public abstract ObjectBuilder createInfNFeBuilder();

	public abstract ObjectBuilder createInfNFeCobrBuilder();

	public abstract ObjectBuilder createInfNFeCobrFatBuilder();

	public abstract ObjectBuilder createInfNFeCobrDupBuilder();

	public abstract ObjectBuilder createInfNFeDestBuilder();

	public abstract ObjectBuilder createInfNfeDetBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoCofinsBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoCofinsSTBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoIcmsBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoIcmsIcms00Builder();

	public abstract ObjectBuilder createInfNfeDetImpostoIIBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoIPIBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoISSQNBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoPISBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoPISPisAliqBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoPISPisNTBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoPISPisOutrBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoPISPisQtdeBuilder();

	public abstract ObjectBuilder createInfNfeDetImpostoPisSTBuilder();

	public abstract ObjectBuilder createInfNfeDetProdBuilder();

	public abstract ObjectBuilder createInfNfeDetProdArmaBuilder();

	public abstract ObjectBuilder createInfNfeDetProdCombBuilder();

	public abstract ObjectBuilder createInfNfeDetProdDiBuilder();

	public abstract ObjectBuilder createInfNfeDetProdDiAdiBuilder();

	public abstract ObjectBuilder createInfNfeDetProdMedBuilder();

	public abstract ObjectBuilder createInfNfeDetProdVeicProdBuilder();

	public abstract ObjectBuilder createInfNfeEmitBuilder();

	public abstract ObjectBuilder createInfNfeIdeBuilder();

	public abstract ObjectBuilder createInfNfeTotalBuilder();

	public abstract ObjectBuilder createInfNfeTotalIcmsTotBuilder();

	public abstract ObjectBuilder createInfNfeTranspBuilder();

	public abstract ObjectBuilder createInfNfeTranspTransportadoraBuilder();

	public abstract ObjectBuilder createNfeSignatureBuilder();

}
