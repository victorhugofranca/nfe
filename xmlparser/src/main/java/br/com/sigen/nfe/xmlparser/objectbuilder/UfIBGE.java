package br.com.sigen.nfe.xmlparser.objectbuilder;

public enum UfIBGE {

	AC(12), AL(27), AM(13), AP(16), BA(29), CE(23), DF(53), ES(32), GO(52), MA(
			21), MG(31), MS(50), MT(51), PA(15), PB(25), PE(26), PI(22), PR(41), RJ(
			33), RN(24), RO(11), RR(14), RS(43), SC(42), SE(28), SP(35), TO(17);

	private int codigoIBGE;

	public String value() {
		return name();
	}

	private UfIBGE(int codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public static UfIBGE fromValue(String v) {
		return valueOf(v);
	}

	public int getCodigoIBGE() {
		return this.codigoIBGE;
	}

}
