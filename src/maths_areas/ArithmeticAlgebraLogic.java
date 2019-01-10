package maths_areas;

import org.w3c.dom.Document;

import maths_areas.arithmetic_algebra_logic.Absolute;
import maths_areas.arithmetic_algebra_logic.Addition;
import maths_areas.arithmetic_algebra_logic.Brackets;
import maths_areas.arithmetic_algebra_logic.ComplexConjugate;
import maths_areas.arithmetic_algebra_logic.Division;
import maths_areas.arithmetic_algebra_logic.Factorial;
import maths_areas.arithmetic_algebra_logic.GcdLcm;
import maths_areas.arithmetic_algebra_logic.Indicies;
import maths_areas.arithmetic_algebra_logic.MaxMin;
import maths_areas.arithmetic_algebra_logic.Multiplication;
import maths_areas.arithmetic_algebra_logic.Quotient;
import maths_areas.arithmetic_algebra_logic.Remainder;
import maths_areas.arithmetic_algebra_logic.StandardFunctions;
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
		//TODO sort order:
		Brackets b = new Brackets(doc);
		
		Quotient q = new Quotient(doc); // And floor
		Remainder r = new Remainder(doc);
		Factorial f = new Factorial(doc);
		MaxMin mm = new MaxMin(doc);
		GcdLcm gl = new GcdLcm(doc);
		Absolute ab = new Absolute(doc);
		StandardFunctions sf = new StandardFunctions(doc);
		ComplexConjugate c = new ComplexConjugate(doc);		
		
		Indicies i = new Indicies(doc);
		Division d = new Division(doc);
		Multiplication m = new Multiplication(doc);
		Addition a = new Addition(doc);
		Subtraction s = new Subtraction(doc);

	}


}
