package simple_arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Brackets {

	private Document doc;
	
	public Brackets(Document doc) {
		this.doc = doc;
		try {
			sortBrackets();
		}catch (NullPointerException e) {
			System.out.println("The bracket grouping you have selected does not fit.\n"
					+ "Please try again");
			System.exit(0);
		}
	}
	
	
	/*
	 * Group together sibling nodes in <mo> brackets
	 */
	private void sortBrackets() {		
		// Pair together the brackets
		List<Node> checkList;
		while(getNextBracket() != null) {
			checkList = new ArrayList<Node>();
			Node next = getNextBracket();
			checkList.add(next);
			do {
				next = next.getNextSibling();
				while(!next.getTextContent().equals(")")){
					checkList.add(next);
					next = next.getNextSibling();
				}
				checkList.add(next);
			}while(!check(checkList));
			enlcose(checkList);
		}
	}
		
	/*
	 * Create an <mfenced> node and adopt children of the <mo> bracket grouping
	 */
	private void enlcose(List<Node> checkList) {
		Node fenced  = doc.renameNode(checkList.get(0), null, "mfenced");
		fenced.setTextContent(null);
		Node row = doc.createElement("mrow");
		for(int i = 1; i < checkList.size(); i ++) {
			row.appendChild(checkList.get(i));
		}
		row.removeChild(row.getLastChild());
		fenced.appendChild(row);
	}
	
	/*
	 * Get the next available bracket from the document or return null if EOF
	 */
	private Node getNextBracket() {
		NodeList tempNodes = doc.getElementsByTagName("mo");
		for(int i = 0; i < tempNodes.getLength(); i++) {
			if (tempNodes.item(i).getTextContent().equals("(")) {
				return tempNodes.item(i);
			}
		}		
		return null;
	}
	
	/*
	 * Ask the user to check a bracket grouping to be finalised.
	 */
	//TODO calculate when brackets should be grouped instead of asking the user 
	private boolean check(List<Node> nodes) {
		for(Node n : nodes) {
			System.out.print(" " + n.getNodeName() + n.getTextContent() + " ");
		}
		System.out.println("Correct? y/n");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        String inputString = scanner. nextLine();
		return inputString.equals("y");
	}
}
