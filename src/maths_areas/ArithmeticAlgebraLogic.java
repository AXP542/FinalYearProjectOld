package maths_areas;

import org.w3c.dom.Document;

import maths_areas.arithmetic_algebra_logic.Addition;
import maths_areas.arithmetic_algebra_logic.Brackets;
import maths_areas.arithmetic_algebra_logic.Division;
import maths_areas.arithmetic_algebra_logic.Factorial;
import maths_areas.arithmetic_algebra_logic.Indicies;
import maths_areas.arithmetic_algebra_logic.MaxMin;
import maths_areas.arithmetic_algebra_logic.Multiplication;
import maths_areas.arithmetic_algebra_logic.Quotient;
import maths_areas.arithmetic_algebra_logic.Subtraction;

public class ArithmeticAlgebraLogic{
	
	public Document doc; 
	
	public ArithmeticAlgebraLogic(Document doc) {
		this.doc = doc;
	}

	/*
	 * Convert all presentation that maps onto this area of maths
	 */
	@SuppressWarnings("unused")
	public void convert() {
		//TODO sort
		Brackets b = new Brackets(doc);
		
		Quotient q = new Quotient(doc);
		Factorial f = new Factorial(doc);
		MaxMin mm = new MaxMin(doc);
		
//		Indicies i = new Indicies(doc);
//		Division d = new Division(doc);
//		Multiplication m = new Multiplication(doc);
//		Addition a = new Addition(doc);
//		Subtraction s = new Subtraction(doc);

	}


}
