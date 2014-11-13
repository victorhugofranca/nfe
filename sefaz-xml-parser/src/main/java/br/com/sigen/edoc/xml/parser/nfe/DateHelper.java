package br.com.sigen.edoc.xml.parser.nfe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper extends java.util.Date {

	public static String strToStr(String dateStr, String srcPattern,
			String targetPattern) throws ParseException {

		SimpleDateFormat srcDateFormat = new SimpleDateFormat(srcPattern);
		SimpleDateFormat targetDateFormat = new SimpleDateFormat(targetPattern);

		Date date = srcDateFormat.parse(dateStr);

		return targetDateFormat.format(date);
	}
}
