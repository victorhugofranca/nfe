package br.com.sigen.edoc.xml.parser.nfe;

public class NumberHelper {

	public static String removeLeftZeros(String number) {
		return String.valueOf(new Integer(number));
	}

	public static String leftPad(String number, int size) {
		return String.format("%0" + size + "d", Integer.valueOf(number));
	}

}
