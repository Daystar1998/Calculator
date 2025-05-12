package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import utils.math.MathStringParser;

class MathStringParserTests {
	
	MathStringParser mathParser = new MathStringParser();
	
	@Test
	void testEvaluateEquationSingleNumber1() throws Exception {
		
		String equation = "80";

		Assertions.assertEquals(80, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationSingleNumber2() throws Exception {
		
		String equation = "-6";

		Assertions.assertEquals(-6, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationSingleNumber3() throws Exception {
		
		String equation = "0.7";

		Assertions.assertEquals(0.7, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationSingleNumber4() throws Exception {
		
		String equation = "9.43";

		Assertions.assertEquals(9.43, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationSingleNumber5() throws Exception {
		
		String equation = "-.7774";

		Assertions.assertEquals(-0.7774, mathParser.evaluateEquation(equation));
	}

	@Test
	void testEvaluateEquationAddition1() throws Exception {
		
		String equation = "2 + 2";

		Assertions.assertEquals(4, mathParser.evaluateEquation(equation));
	}

	@Test
	void testEvaluateEquationAddition2() throws Exception {
		
		String equation = "56+ -4";

		Assertions.assertEquals(52, mathParser.evaluateEquation(equation));
	}

	@Test
	void testEvaluateEquationAddition3() throws Exception {
		
		String equation = "-0.5 +-4";

		Assertions.assertEquals(-4.5, mathParser.evaluateEquation(equation));
	}

	@Test
	void testEvaluateEquationAddition4() throws Exception {
		
		String equation = "-3+-2";

		Assertions.assertEquals(-5, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationSubtraction1() throws Exception {
		
		String equation = "0 - 5";

		Assertions.assertEquals(-5, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationSubtraction2() throws Exception {
		
		String equation = "78- -5";

		Assertions.assertEquals(83, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationSubtraction3() throws Exception {
		
		String equation = "-7 -3";

		Assertions.assertEquals(-10, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationSubtraction4() throws Exception {
		
		String equation = "-3--9";

		Assertions.assertEquals(6, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationMultiplication1() throws Exception {
		
		String equation = "2 * 4";

		Assertions.assertEquals(8, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationMultiplication2() throws Exception {
		
		String equation = "-12 *6";

		Assertions.assertEquals(-72, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationMultiplication3() throws Exception {
		
		String equation = "0* 2";

		Assertions.assertEquals(0, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationMultiplication4() throws Exception {
		
		String equation = "7*-0.5";

		Assertions.assertEquals(-3.5, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationMultiplicationAlt1() throws Exception {
		
		String equation = "2 × 4";

		Assertions.assertEquals(8, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationMultiplicationAlt2() throws Exception {
		
		String equation = "-12 ×6";

		Assertions.assertEquals(-72, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationMultiplicationAlt3() throws Exception {
		
		String equation = "0× 2";

		Assertions.assertEquals(0, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationMultiplicationAlt4() throws Exception {
		
		String equation = "7*-0.5";

		Assertions.assertEquals(-3.5, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationDivision1() throws Exception {
		
		String equation = "24 / 2";

		Assertions.assertEquals(12, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationDivision2() throws Exception {
		
		String equation = "50 /-5";

		Assertions.assertEquals(-10, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationDivision3() throws Exception {
		
		String equation = "-4/ 10";

		Assertions.assertEquals(-0.4, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationDivision4() throws Exception {
		
		String equation = "70/2";

		Assertions.assertEquals(35, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationDivisionAlt1() throws Exception {
		
		String equation = "24 ÷ 2";

		Assertions.assertEquals(12, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationDivisionAlt2() throws Exception {
		
		String equation = "50 ÷-5";

		Assertions.assertEquals(-10, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationDivisionAlt3() throws Exception {
		
		String equation = "-4÷ 10";

		Assertions.assertEquals(-0.4, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationDivisionAlt4() throws Exception {
		
		String equation = "70÷2";

		Assertions.assertEquals(35, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationExponent1() throws Exception {
		
		String equation = "3 ^ 2";

		Assertions.assertEquals(9, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationExponent2() throws Exception {
		
		String equation = "4 ^0";

		Assertions.assertEquals(1, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationExponent3() throws Exception {
		
		String equation = "7^ 3";

		Assertions.assertEquals(343, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationExponent4() throws Exception {
		
		String equation = "-2^3";

		Assertions.assertEquals(-8, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationExponent5() throws Exception {
		
		String equation = "-4^6";

		Assertions.assertEquals(4096, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationExponent6() throws Exception {
		
		String equation = "5^-3";

		Assertions.assertEquals(0.008, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationPercentage1() throws Exception {
		
		String equation = "10%";

		Assertions.assertEquals(0.1, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationPercentage2() throws Exception {
		
		String equation = "5%";

		Assertions.assertEquals(0.05, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationPercentage3() throws Exception {
		
		String equation = "-80%";

		Assertions.assertEquals(-0.8, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationParentheses1() throws Exception {
		
		String equation = "(6";

		Assertions.assertEquals(6, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationParentheses2() throws Exception {
		
		String equation = "7)";

		Assertions.assertEquals(7, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationParentheses3() throws Exception {
		
		String equation = "(-4)";

		Assertions.assertEquals(-4, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations1() throws Exception {
		
		String equation = "4 * (5+6)";

		Assertions.assertEquals(44, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations2() throws Exception {
		
		String equation = "(2 - 4) / 2";

		Assertions.assertEquals(-1, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations3() throws Exception {
		
		String equation = "4 + 2 * 5";

		Assertions.assertEquals(14, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations4() throws Exception {
		
		String equation = "6 / 2 - 5";

		Assertions.assertEquals(-2, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations5() throws Exception {
		
		String equation = "-(5 * 2)";

		Assertions.assertEquals(-10, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations6() throws Exception {
		
		String equation = "-3^2 + 5";

		Assertions.assertEquals(14, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations7() throws Exception {
		
		String equation = "5% * 20";

		Assertions.assertEquals(1, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations8() throws Exception {
		
		String equation = "4 / 50%";

		Assertions.assertEquals(8, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations9() throws Exception {
		
		String equation = "4 + 6 ÷ 3";

		Assertions.assertEquals(6, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations10() throws Exception {
		
		String equation = "(4 + 6) × 3";

		Assertions.assertEquals(30, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations11() throws Exception {
		
		String equation = "6 / 2 × 3";

		Assertions.assertEquals(9, mathParser.evaluateEquation(equation));
	}
	
	@Test
	void testEvaluateEquationOrderOfOperations12() throws Exception {
		
		String equation = "4 × 8 ÷ 2";

		Assertions.assertEquals(16, mathParser.evaluateEquation(equation));
	}
}
