package simple_arithmetic;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Subtraction {

	private Document doc;
	private List<String> symbols;
	
	public Subtraction(Document doc) {
		this.doc = doc;
		symbols = new ArrayList<String>();
		symbols.add("-");
		convert();
	}
	
	
	/*
	 * Convert all occurrences of the symbols in the symbols list to an apply tag
	 */
	private void convert() {
		NodeList nl = doc.getElementsByTagName("mo");
		List<Node> subSigns = new ArrayList<Node>();
		
		for (int i = 0; i < nl.getLength(); i++) {
			String s = nl.item(i).getTextContent();
			if(symbols.contains(s))
				subSigns.add(nl.item(i));
		}
		
		for(int i = 0; i < subSigns.size(); i ++) {
			Node sub = subSigns.get(i);
			sub.setTextContent(null);
			doc.renameNode(sub, null, "apply");
			sub.appendChild(doc.createElement("minus"));
			sub.appendChild(sub.getPreviousSibling());
			sub.appendChild(sub.getNextSibling());

		}
	}
}
