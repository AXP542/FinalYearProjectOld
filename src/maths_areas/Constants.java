package maths_areas;

import org.w3c.dom.Document;

import maths_areas.constants.SimpleNumbersAndVars;

public class Constants {

	private Document doc;
	
	public Constants(Document doc) {
		this.doc = doc;
	}
	
	/*
	 * Convert all presentation that maps onto this area of maths
	 */
	@SuppressWarnings("unused")
	public void convert() {
		SimpleNumbersAndVars nv = new SimpleNumbersAndVars(doc);
	}
}
