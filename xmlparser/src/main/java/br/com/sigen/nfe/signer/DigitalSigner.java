package br.com.sigen.nfe.signer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DigitalSigner {

	private static final String C14N_TRANSFORM_METHOD = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";

	private static XMLSignatureFactory fac;
	private static ArrayList<Transform> transformList;
	private static KeyStore.PrivateKeyEntry keyEntry;
	private static KeyInfo ki;

	private static Document carregarDocumentoParaAssinar(String xml,
			InputStream certIS, String certPassword) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);

		Document doc = factory.newDocumentBuilder().parse(
				new ByteArrayInputStream(xml.getBytes()));

		// Create a DOM XMLSignatureFactory that will be used to
		// generate the enveloped signature.
		fac = XMLSignatureFactory.getInstance("DOM");

		// Create a Reference to the enveloped document (in this case,
		// you are signing the whole document, so a URI of "" signifies
		// that, and also specify the SHA1 digest algorithm and
		// the ENVELOPED Transform.
		transformList = new ArrayList<Transform>();
		TransformParameterSpec tps = null;
		Transform envelopedTransform = fac.newTransform(Transform.ENVELOPED,
				tps);
		Transform c14NTransform = fac.newTransform(C14N_TRANSFORM_METHOD, tps);

		transformList.add(envelopedTransform);
		transformList.add(c14NTransform);

		// Load the KeyStore and get the signing key and certificate.
		KeyStore ks = KeyStore.getInstance("PKCS12");

		// load the keystore
		ks.load(certIS, certPassword.toCharArray());

		String alias = ks.aliases().nextElement();

		keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias,
				new KeyStore.PasswordProtection(certPassword.toCharArray()));

		X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

		// Create the KeyInfo containing the X509Data.
		KeyInfoFactory kif = fac.getKeyInfoFactory();

		List<X509Certificate> x509Content = new ArrayList<X509Certificate>();
		// x509Content.add(cert.getSubjectX500Principal().getName());
		x509Content.add(cert);

		X509Data xd = kif.newX509Data(x509Content);
		ki = kif.newKeyInfo(Collections.singletonList(xd));

		return doc;
	}

	public byte[] sign(String xml, InputStream certIS,
			String certPassword) throws Exception {

		if (xml != null) {

			Document doc = carregarDocumentoParaAssinar(xml, certIS,
					certPassword);

			assinarDocumento(doc);

			ByteArrayOutputStream os = tranformarDocumentoEmStream(doc);
			return os.toByteArray();
		}
		return null;
	}

	private static void assinarDocumento(Document doc) throws Exception {

		NodeList elements = doc.getElementsByTagName("infNFe");
		Element el = (Element) elements.item(0);
		String id = el.getAttribute("Id");
		el.setIdAttribute("Id", true);

		gerarAssinatura(fac, transformList, keyEntry.getPrivateKey(), ki, doc,
				id);
	}

	private static ByteArrayOutputStream tranformarDocumentoEmStream(
			Document doc) throws TransformerFactoryConfigurationError,
			TransformerConfigurationException, TransformerException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		trans.transform(new DOMSource(doc), new StreamResult(os));

		return os;
	}

	private static void gerarAssinatura(XMLSignatureFactory fac,
			ArrayList<Transform> transformList, PrivateKey privateKey,
			KeyInfo ki, Document doc, String id) throws Exception {

		// Create a DOM XMLSignatureFactory that will be used to
		// generate the enveloped signature.
		Reference ref = fac.newReference("#" + id,
				fac.newDigestMethod(DigestMethod.SHA1, null), transformList,
				null, null);

		// Create the SignedInfo.
		SignedInfo si = fac
				.newSignedInfo(fac.newCanonicalizationMethod(
						CanonicalizationMethod.INCLUSIVE,
						(C14NMethodParameterSpec) null), fac
						.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
						Collections.singletonList(ref));

		// Create the XMLSignature, but don't sign it yet.
		XMLSignature signature = fac.newXMLSignature(si, ki);

		// Marshal, generate, and sign the enveloped signature.
		// Create a DOMSignContext and specify the RSA PrivateKey and
		// location of the resulting XMLSignature's parent element.

		DOMSignContext dsc = new DOMSignContext(privateKey, doc
				.getElementsByTagName("NFe").item(0));

		signature.sign(dsc);
	}

}
