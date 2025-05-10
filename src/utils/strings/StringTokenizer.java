package utils.strings;

import java.util.ArrayList;

/*
 * Class for dividing a string into identified tokens
 */
public class StringTokenizer {
	
	private ArrayList<Token> tokens;
	
	private String numberBuffer;
	private String functionBuffer;
	private Token previousToken;
	private boolean containsDecimal;

	public ArrayList<Token> tokenizeString(String data) throws Exception {
		
		tokens = new ArrayList<Token>();
		
		if(data == null)
			return tokens;
		
		numberBuffer = "";
		functionBuffer = "";
		previousToken = null;
		containsDecimal = false;

		for (int i = 0; i < data.length(); i++) {

			if (Character.isDigit(data.charAt(i)) || data.charAt(i) == '.') {

				flushFunctionBuffer();
					
				if(data.charAt(i) == '.') {
					
					if(!containsDecimal)
						containsDecimal = true;
					else
						throw new Exception("Number cannot contain multiple decimal points");
				}
				
				numberBuffer += data.charAt(i);
			} else if (Character.isLetter(data.charAt(i))) {
				
				flushNumberBuffer();

				functionBuffer += data.charAt(i);
			} else if (isOperator(data.charAt(i))) {
				
				flushNumberBuffer();
				flushFunctionBuffer();
				
				previousToken = new Token(LexicalCategory.OPERATOR, Character.toString(data.charAt(i)));
				tokens.add(previousToken);
			} else if (data.charAt(i) == '(' || data.charAt(i) == ')') {
				
				flushNumberBuffer();
				flushFunctionBuffer();

				previousToken = new Token(LexicalCategory.PARENTHESIS, Character.toString(data.charAt(i)));
				tokens.add(previousToken);
			} else if(Character.isWhitespace(data.charAt(i))) {
			
				flushNumberBuffer();
				flushFunctionBuffer();
			}else
				throw new Exception("Invalid input");
		}

		flushNumberBuffer();
		flushFunctionBuffer();

		return tokens;
	}
	
	public boolean isOperator(char c) {
		
		boolean result = false;
		
		switch(c) {
			
			case '^':
			case '*':
			case '×':
			case '/':
			case '÷':
			case '%':
			case '+':
			case '-':
				result = true;
		}
		
		return result;
	}
	
	private void flushNumberBuffer() throws Exception {
		
		if(numberBuffer.length() > 0) {
			
			if(containsDecimal && numberBuffer.length() == 1)
				throw new Exception("Number cannot contain only a decimal point");

			previousToken = new Token(LexicalCategory.NUMBER, numberBuffer);
			tokens.add(previousToken);
			containsDecimal = false;
			numberBuffer = "";
		}
	}
	
	private void flushFunctionBuffer() {
		
		if(functionBuffer.length() > 0) {
			
			previousToken = new Token(LexicalCategory.FUNCTION, functionBuffer);
			tokens.add(previousToken);
			functionBuffer = "";
		}
	}
}
