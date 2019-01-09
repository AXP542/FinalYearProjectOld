package simple_arithmetic;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Multiplication {

	private Document doc;
	private List<String> symbols;
	
	public Multiplication(Document doc) {
		this.doc = doc;
		symbols = new ArrayList<String>();
		symbols.add("&invisibletimes;");
		symbols.add("&it;");
		symbols.add("&#x2A09;");
		symbols.add("&#xD7;");
		symbols.add("&#xB7;");
		symbols.add("x");
		symbols.add("�");
		symbols.add(".");
		findInvisibleTimes();
		convert();
	}
	
	/*
	 * Convert all occurrences of the symbols in the symbols list to an apply tag
	 */
	private void convert() {
		NodeList nl = doc.getElementsByTagName("mo");
		List<Node> multSigns = new ArrayList<Node>();
		
		for (int i = 0; i < nl.getLength(); i++) {
			String s = nl.item(i).getTextContent();
			if(symbols.contains(s))
				multSigns.add(nl.item(i));
		}
		
		for(int i = 0; i < multSigns.size(); i ++) {
			Node mult = multSigns.get(i);
			mult.setTextContent(null);
			doc.renameNode(mult, null, "apply");
			mult.appendChild(doc.createElement("times"));
			mult.appendChild(mult.getPreviousSibling());
			mult.appendChild(mult.getNextSibling());
			try {
				while(mult.getNextSibling().equals(multSigns.get(i + 1))) {
					Node nullMult = mult.getNextSibling();
					mult.appendChild(nullMult);
					mult.removeChild(nullMult);
					mult.appendChild(mult.getNextSibling());
					i++;
					if(mult.getNextSibling() == null)
						break;
				}
			}catch (NullPointerException| IndexOutOfBoundsException e) {
				// Expected to catch the last element to be multiplied and the last multiplication
			}
		}
	}
	
	
	/*
	 * Check with the user if 2 elements should be multiplied together.
	 * If so add invisible times symbol;
	 */
	private void findInvisibleTimes() {
		//TODO maybe move to an arithmetic class which contains all other arithmetic classes.
		
		NodeList vars = doc.getElementsByTagName("mi");
		NodeList nums = doc.getElementsByTagName("mn");
		for(int i = 0; i < vars.getLength(); i++) {
			Node var = vars.item(i);
			if(var.getNextSibling() != null && 
					!var.getNextSibling().getNodeName().equals("mo")) {
				
				System.out.println("Should this be:" + var.getTextContent() 
					+ " times " + var.getNextSibling().getTextContent());
			}
		}

		for(int i = 0; i < nums.getLength(); i++) {
			Node num = nums.item(i);
			if(num.getNextSibling() != null && 
					!num.getNextSibling().getNodeName().equals("mo")) {
				
				System.out.println("Should this be:" + num.getTextContent() 
					+ " times " + num.getNextSibling().getTextContent());
			}
		}
		
	}
	
}