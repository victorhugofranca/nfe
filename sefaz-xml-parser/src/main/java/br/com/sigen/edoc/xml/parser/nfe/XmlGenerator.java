package br.com.sigen.edoc.xml.parser.nfe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
//import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderException;
import br.com.sigen.edoc.xml.parser.nfe.objectbuilder.ObjectBuilderFacade;
import br.com.sigen.edoc.xml.parser.nfe.signer.DigitalSigner;
import br.inf.portalfiscal.nfe.TEnviNFe;

public class XmlGenerator {

	public static void main(String[] args) throws IOException,
			ObjectBuilderException {
		XmlGenerator xmlGenerator = new XmlGenerator();
		xmlGenerator.test();
	}

	public void test() throws IOException
	// , ObjectBuilderException
	{

		// /////////////GERAR JSON
		byte[] jsonEncoded = Files
				.readAllBytes(Paths
						.get("//Users//victorfranca//desenvolvimento//workspace_nfe//testDataGeneration//nfe1.json"));
		String json = new String(jsonEncoded, StandardCharsets.UTF_8);
		// System.out.println(json);
		// NfeDataPool nfeDataPool = NfeDataPool.instance();
		// nfeDataPool.addNfeData("1", json);

		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject) parser.parse(json);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao realizar parse do Json");
		}

		// System.out.println(jsonObject.toJSONString());

		// ///////////GERAR XML
		ObjectBuilderFacade facade = new ObjectBuilderFacade();
		TEnviNFe tEnviNFe = null;
		try {
			tEnviNFe = facade.buildEnviFe(jsonObject);
		} catch (ObjectBuilderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String xml = null;
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(TEnviNFe.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.FALSE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			StringWriter writer = new StringWriter();
			XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance()
					.createXMLStreamWriter(writer);

			jaxbMarshaller.marshal(tEnviNFe, xmlStreamWriter);

			// output pretty printed
			// jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
			// true);
			// jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			xml = writer
					.toString()
					.replaceAll(
							"xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" ",
							"")
					.replaceAll("<NFe>",
							"<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">")
					.replaceAll("tEnviNFe", "enviNFe")
			// .replace("xmlns:nf2=", "xmlns=")
			;

			// System.out.println(xml);

		} catch (JAXBException e) {
			throw new RuntimeException("Erro ao gerar XML");
		} catch (XMLStreamException e) {
			throw new RuntimeException("Erro ao gerar XML");
		} catch (FactoryConfigurationError e) {
			throw new RuntimeException("Erro ao gerar XML");
		}

		// ASSINAR XML
		DigitalSigner digitalSigner = new DigitalSigner();
		FileInputStream certificado = new FileInputStream(
				new File(
						"//Users//victorfranca//Dropbox//SIGEN//FATURAMENTO//certificado_digital//2014.pfx"));
		byte[] xmlAssinado = null;
		try {
			xmlAssinado = digitalSigner.sign(xml, certificado, "acloex");
			System.out.println(new String(xmlAssinado));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao assinar XML: " + e.getMessage());
		}

		// ///////////VALIDAR XML
		XmlValidator xmlValidator = new XmlValidator();
		xmlValidator.validate(xmlAssinado);

		// To directly connect to a single MongoDB server (note that this will
		// not auto-discover the primary even
		// if it's a member of a replica set:
		// or
		// MongoClient mongoClient = new MongoClient("localhost", 27017);
		//
		// DB db = mongoClient.getDB("names");
		//
		// DBCollection coll = db.getCollection("mynames");
		//
		// BasicDBObject query = new BasicDBObject("name", "victor");
		//
		// DBCursor cursor = coll.find(query);
		// try {
		// while (cursor.hasNext()) {
		// System.out.println(cursor.next());
		// }
		// } finally {
		// cursor.close();
		// }

	}

}
