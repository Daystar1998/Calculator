package utils.math;

public class OperatorPrecedence {

	private static final int OPENING_PARENTHESIS = 0;
	private static final int ADD_SUB = 1;
	private static final int MULT_DIV = 2;
	private static final int EXPONENT = 3;
	private static final int CLOSING_PARENTHESIS = 4;
	
	public static int getPrecedence(String operator) {
		
		int result = -1;
		
		switch(operator) {
			
			case "(":
				
				result = OPENING_PARENTHESIS;
				break;
			case ")":
				
				result = CLOSING_PARENTHESIS;
				break;
			case "^":
				
				result = EXPONENT;
				break;
			case "*":
			case "×":
			case "/":
			case "÷":
				
				result = MULT_DIV;
				break;
			case "+":
			case "-":
				
				result = ADD_SUB;
		}
		
		return result;
	}
	
	public static int comparePrecedence(String first, String second) {
		
		int firstPrecedence = getPrecedence(first);
		int secondPrecedence = getPrecedence(second);
		
		return firstPrecedence - secondPrecedence;
	}
}
