package main;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class run {

	public static void main(String[] args) {
		
		
		try {
			byte[] encoded = Files.readAllBytes(Paths.get("input"));
			String input = new String(encoded, Charset.defaultCharset());
			input = input.replaceAll("&", "&amp;");
			
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(input));
			Document doc = db.parse(is);
			
			Presentation2Content mathDoc = new Presentation2Content(doc);
			mathDoc.print();

			
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

}
