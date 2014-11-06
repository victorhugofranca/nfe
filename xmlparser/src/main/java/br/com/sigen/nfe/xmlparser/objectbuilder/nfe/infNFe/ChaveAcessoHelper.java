package br.com.sigen.nfe.xmlparser.objectbuilder.nfe.infNFe;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

import br.com.sigen.nfe.NumberHelper;

/**
 * classe com os campos pertencentes a chave de acesso, segundo o formato abaixo
 * ****************************************************************************
 * ********* CUF | AAMM emi | CNPJ | Mod | Série | NNF | TpEmis | cNf | cDV|
 * *TAMANHO* 02 *| ***04*** | *14* | 02* | 03*** | 09* | **01** | *08 | 01 |
 * ****************************************************************************
 * ****************************************************************************
 */

public class ChaveAcessoHelper {

	private String cUF;
	private String aaMM;
	private String cnpj;
	private String mod;
	private String serie;
	private String nNF;
	private String tpEmis;
	private String cNF;
	private String cDV;
	private String chaveGerada;

	public ChaveAcessoHelper(String cUF, String aaMM, String cnpj, String mod,
			String serie, String nNF, String tpEmis, String cNF) {

		this.cUF = cUF;
		this.aaMM = aaMM;
		this.cnpj = cnpj;
		this.mod = mod;
		this.serie = NumberHelper.leftPad(serie, 3);
		this.nNF = new DecimalFormat("000000000").format(Long.parseLong(nNF)); // 9
		this.tpEmis = tpEmis;
		this.cNF = cNF;
	}

	public String getcUF() {
		return cUF;
	}

	public void setcUF(String cUF) {
		this.cUF = cUF;
	}

	public String getAaMM() {
		return aaMM;
	}

	public void setAaMM(String aaMM) {
		this.aaMM = aaMM;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getnNF() {
		return nNF;
	}

	public void setnNF(String nNF) {
		this.nNF = nNF;
	}

	public String getTpEmis() {
		return tpEmis;
	}

	public void setTpEmis(String tpEmis) {
		this.tpEmis = tpEmis;
	}

	public String getcNF() {
		return cNF;
	}

	public void setcNF(String cNF) {
		this.cNF = cNF;
	}

	public String getcDV() {
		return cDV;
	}

	public void setcDV(String cDV) {
		this.cDV = cDV;
	}

	private String getChaveComDVCalculado(String chaveSemDigito) {

		// UMA CHAVE DE ACESSO DE NF-E TEM 44 DIGITOS, ENTAO O CALCULO SE DÁ COM
		// OS 43 ANTERIORES

		if (chaveSemDigito.length() != 43)
			throw new InputMismatchException("A chave contém "
					+ chaveSemDigito.length()
					+ " dígitos. A correta deve ter 44 caracteres");

		int[] aux = new int[chaveSemDigito.length()];
		int variavel = 2;
		int total = 0;
		int dv = 0;

		for (int i = aux.length - 1; i >= 0; i--) {
			aux[i] = Integer.parseInt("" + chaveSemDigito.charAt(i));
			aux[i] = aux[i] * variavel;
			variavel++;

			if (variavel > 9)
				variavel = 2;

			total += aux[i];
		}

		// Quando o resto da divisão for 0 (zero) ou 1 (um), o DV deverá ser
		// igual a 0 (zero).
		int resto = total % 11;
		if (/* total */resto == 0 || /* total */resto == 1)
			dv = 0;
		else
			dv = 11 - /* (total % 11) */resto;

		this.cDV = String.valueOf(dv);

		this.chaveGerada = chaveSemDigito + cDV;

		return chaveGerada;
	}

	@Override
	public String toString() {
		String chave = cUF + aaMM + cnpj + mod + serie + nNF + tpEmis + cNF;
		return "NFe" + getChaveComDVCalculado(chave);
	}

}
