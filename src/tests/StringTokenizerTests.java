package tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import utils.strings.LexicalCategory;
import utils.strings.StringTokenizer;
import utils.strings.Token;

/*
 * Unit testing for StringTokenizer
 */
class StringTokenizerTests {

	private Set<Character> operatorSet = new HashSet<Character>(Arrays.asList('^', '*', '×', '/', '÷', '%', '+', '-'));
	private StringTokenizer stringTokenizer = new StringTokenizer();

	@Test
	void testTokenizeStringNull() throws Exception {

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(null);

		Assertions.assertEquals(0, tokens.size());
	}

	@Test
	void testTokenizeStringEmpty() throws Exception {

		String testString = "";

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(0, tokens.size());
	}

	@Test
	void testTokenizeStringSingleDigit() throws Exception {

		for (char c = '0'; c <= '9'; c++) {

			String testString = Character.toString(c);

			ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

			Assertions.assertEquals(1, tokens.size());

			Token token = tokens.get(0);
			Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
			Assertions.assertEquals(testString, token.getValue());
		}
	}

	@Test
	void testTokenizeStringMaxInt() throws Exception {

		String testString = Integer.toString(Integer.MAX_VALUE);

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(1, tokens.size());

		Token token = tokens.get(0);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals(testString, token.getValue());
	}

	@Test
	void testTokenizeStringMinInt() throws Exception {

		String testString = Integer.toString(Integer.MIN_VALUE);

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(2, tokens.size());

		Token token = tokens.get(0);
		Assertions.assertEquals(LexicalCategory.OPERATOR, token.getCategory());
		Assertions.assertEquals("-", token.getValue());

		token = tokens.get(1);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals(testString.substring(1), token.getValue());
	}

	@Test
	void testTokenizeStringIntRandomFuzz() throws Exception {

		Random random = new Random();

		for (int i = 0; i < 10000; i++) {

			String testString = Integer.toString(random.nextInt(Integer.MAX_VALUE));

			ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

			Assertions.assertEquals(1, tokens.size());

			Token token = tokens.get(0);
			Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
			Assertions.assertEquals(testString, token.getValue());
		}
	}

	@Test
	void testTokenizeStringMaxDouble() throws Exception {

		String testString = new BigDecimal(Double.MAX_VALUE).toPlainString();

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(1, tokens.size());

		Token token = tokens.get(0);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals(testString, token.getValue());
	}

	@Test
	void testTokenizeStringMinDouble() throws Exception {

		String testString = new BigDecimal(Double.MIN_VALUE).toPlainString();

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(1, tokens.size());

		Token token = tokens.get(0);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals(testString, token.getValue());
	}

	@Test
	void testTokenizeStringDoubleRandomFuzz() throws Exception {

		Random random = new Random();

		for (int i = 0; i < 10000; i++) {

			String testString = new BigDecimal(random.nextDouble(Double.MAX_VALUE)).toPlainString();

			ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

			Assertions.assertEquals(1, tokens.size());

			Token token = tokens.get(0);
			Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
			Assertions.assertEquals(testString, token.getValue());
		}
	}

	@Test
	void testTokenizeStringDoubleStartsWithDecimal() throws Exception {

		String testString = ".5";

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(1, tokens.size());

		Token token = tokens.get(0);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals(testString, token.getValue());
	}

	@Test
	void testTokenizeStringThrowsMultipleDecimalException1() {

		String testString = ".5.";

		Exception exception = Assertions.assertThrows(Exception.class,
				() -> stringTokenizer.tokenizeString(testString));

		Assertions.assertEquals("Number cannot contain multiple decimal points", exception.getMessage());
	}

	@Test
	void testTokenizeStringThrowsMultipleDecimalException2() {

		String testString = "5..";

		Exception exception = Assertions.assertThrows(Exception.class,
				() -> stringTokenizer.tokenizeString(testString));

		Assertions.assertEquals("Number cannot contain multiple decimal points", exception.getMessage());
	}

	@Test
	void testTokenizeStringThrowsMultipleDecimalException3() {

		String testString = "..5";

		Exception exception = Assertions.assertThrows(Exception.class,
				() -> stringTokenizer.tokenizeString(testString));

		Assertions.assertEquals("Number cannot contain multiple decimal points", exception.getMessage());
	}

	@Test
	void testTokenizeStringThrowsContainsOnlyDecimal() {

		String testString = ".";

		Exception exception = Assertions.assertThrows(Exception.class,
				() -> stringTokenizer.tokenizeString(testString));

		Assertions.assertEquals("Number cannot contain only a decimal point", exception.getMessage());
	}

	@Test
	void testTokenizeStringThrowsContainsInvalidCharacters() {

		for (char c = 0; c < 256; c++) {

			if (Character.isLetter(c) || Character.isDigit(c) || operatorSet.contains(c) || Character.isWhitespace(c)
					|| c == '(' || c == ')' || c == '.')
				continue;

			String testString = Character.toString(c);

			Exception exception = Assertions.assertThrows(Exception.class,
					() -> stringTokenizer.tokenizeString(testString));

			Assertions.assertEquals("Invalid input", exception.getMessage());
		}
	}

	@Test
	void testTokenizeStringDoesNotThrowForValidCharacters() {

		for (char c = 0; c <= 256; c++) {

			// '.' is not considered valid unless part of a number
			if (Character.isLetter(c) || Character.isDigit(c) || operatorSet.contains(c) || Character.isWhitespace(c)
					|| c == '(' || c == ')') {

				String testString = Character.toString(c);

				Assertions.assertDoesNotThrow(() -> stringTokenizer.tokenizeString(testString));
			}
		}
	}

	@Test
	void testTokenizeStringFunction() throws Exception {

		String testString = "test";

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(1, tokens.size());

		Token token = tokens.get(0);
		Assertions.assertEquals(LexicalCategory.FUNCTION, token.getCategory());
		Assertions.assertEquals(testString, token.getValue());
	}

	@Test
	void testTokenizeStringAllLetters() throws Exception {

		char[] alphabet = new char[52];

		for (char c = 'A'; c <= 'Z'; c++)
			alphabet[c - 'A'] = c;

		for (char c = 'a'; c <= 'z'; c++)
			alphabet[c - 'a' + 26] = c;

		for (int i = 0; i < alphabet.length; i++) {

			String testString = Character.toString(alphabet[i]);

			ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

			Assertions.assertEquals(1, tokens.size());

			Token token = tokens.get(0);
			Assertions.assertEquals(LexicalCategory.FUNCTION, token.getCategory());
			Assertions.assertEquals(testString, token.getValue());
		}
	}

	@Test
	void testTokenizeString1() throws Exception {

		String testString = "func(5+ 6";

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(5, tokens.size());

		Token token = tokens.get(0);
		Assertions.assertEquals(LexicalCategory.FUNCTION, token.getCategory());
		Assertions.assertEquals("func", token.getValue());

		token = tokens.get(1);
		Assertions.assertEquals(LexicalCategory.PARENTHESIS, token.getCategory());
		Assertions.assertEquals("(", token.getValue());

		token = tokens.get(2);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals("5", token.getValue());

		token = tokens.get(3);
		Assertions.assertEquals(LexicalCategory.OPERATOR, token.getCategory());
		Assertions.assertEquals("+", token.getValue());

		token = tokens.get(4);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals("6", token.getValue());
	}

	@Test
	void testTokenizeString2() throws Exception {

		String testString = "func * 1g2";

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(5, tokens.size());

		Token token = tokens.get(0);
		Assertions.assertEquals(LexicalCategory.FUNCTION, token.getCategory());
		Assertions.assertEquals("func", token.getValue());

		token = tokens.get(1);
		Assertions.assertEquals(LexicalCategory.OPERATOR, token.getCategory());
		Assertions.assertEquals("*", token.getValue());

		token = tokens.get(2);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals("1", token.getValue());

		token = tokens.get(3);
		Assertions.assertEquals(LexicalCategory.FUNCTION, token.getCategory());
		Assertions.assertEquals("g", token.getValue());

		token = tokens.get(4);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals("2", token.getValue());
	}

	@Test
	void testTokenizeString4() throws Exception {

		String testString = "1 2";

		ArrayList<Token> tokens = stringTokenizer.tokenizeString(testString);

		Assertions.assertEquals(2, tokens.size());

		Token token = tokens.get(0);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals("1", token.getValue());

		token = tokens.get(1);
		Assertions.assertEquals(LexicalCategory.NUMBER, token.getCategory());
		Assertions.assertEquals("2", token.getValue());
	}

	@Test
	void testIsOperatorTrue() throws Exception {

		for (char c : operatorSet) {

			Assertions.assertTrue(stringTokenizer.isOperator(c));
		}
	}

	@Test
	void testIsOperatorFalse() throws Exception {

		for (char c = 0; c < 256; c++) {

			if(!operatorSet.contains(c))
				Assertions.assertFalse(stringTokenizer.isOperator(c));
		}
	}
}
