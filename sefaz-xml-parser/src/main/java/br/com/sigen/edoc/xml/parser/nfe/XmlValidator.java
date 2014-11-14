package br.com.sigen.edoc.xml.parser.nfe;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator {

	public void validate(byte[] xmlByteArray) {

		InputStream xmlInputStream = new ByteArrayInputStream(xmlByteArray);

		String filePath = "//Users//victorfranca//desenvolvimento//workspace_nfe//sefaz-xml-canonico//src//main//resources//xsd//pl_008e//enviNFe_v3.10.xsd";
		File schemaFile = new File(filePath);

		Source xmlFile = new StreamSource(xmlInputStream);
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Schema schema = null;
		try {
			schema = schemaFactory.newSchema(schemaFile);
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Validator validator = schema.newValidator();
		try {
			validator.validate(xmlFile);
			System.out.println("xml is valid");
		} catch (SAXException e) {
			System.out.println("xml is NOT valid");
			System.out.println("Reason: " + e.getLocalizedMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
