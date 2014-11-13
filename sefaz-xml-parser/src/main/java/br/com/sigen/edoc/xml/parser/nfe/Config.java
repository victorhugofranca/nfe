package br.com.sigen.edoc.xml.parser.nfe;

public class Config {

	public static final String VERSAO = "3.10";

	// 0=Não.
	// 1=Empresa solicita processamento síncrono do Lote de NF-e (sem a geração
	// de Recibo para consulta futura);
	public static final String PROCESSAMENTO_SINCRONO = "0";

	// 1=Produção; 2=Homologação
	public static final String TP_AMB = "2";

	// TODO parametrize
	public static final String VER_PROC = "1.0";

}
