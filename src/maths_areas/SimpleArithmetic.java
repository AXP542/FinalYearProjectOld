package maths_areas;

import org.w3c.dom.Document;

import simple_arithmetic.Addition;
import simple_arithmetic.Brackets;
import simple_arithmetic.Division;
import simple_arithmetic.Indicies;
import simple_arithmetic.Multiplication;
import simple_arithmetic.Subtraction;

public class SimpleArithmetic{
	
	public Document doc; 
	
	public SimpleArithmetic(Document doc) {
		this.doc = doc;
	}

	@SuppressWarnings("unused")
	public void convert() {
		Brackets b = new Brackets(doc);
		Indicies i = new Indicies(doc);
		Division d = new Division(doc);
		Multiplication m = new Multiplication(doc);
		Addition a = new Addition(doc);
		Subtraction s = new Subtraction(doc);
	}


}
