package utils.math;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

import utils.strings.LexicalCategory;
import utils.strings.StringTokenizer;
import utils.strings.Token;

/*
 * Class for parsing and evaluating a math equation
 */
public class MathStringParser {

	private Queue<Token> postfixQueue = new ArrayDeque<Token>();
	private Deque<Token> operatorStack = new ArrayDeque<Token>();
	private Deque<Double> operandStack = new ArrayDeque<Double>();

	private StringTokenizer tokenizer = new StringTokenizer();
	private Token previousToken = null;

	public double evaluateEquation(String equation) throws Exception {

		postfixQueue.clear();
		operatorStack.clear();
		operandStack.clear();

		ArrayList<Token> tokens = tokenizer.tokenizeString(equation);
		convertInfixToPostfix(tokens);

		return calcResult();
	}

	private void convertInfixToPostfix(ArrayList<Token> tokens) {

		for (Token token : tokens) {

			switch (token.getCategory()) {

				case NUMBER:

					postfixQueue.add(token);
					break;
				case FUNCTION:

					operatorStack.push(token);
					break;
				case OPERATOR:

					processOperator(token);
			}

			previousToken = token;
		}

		while (!operatorStack.isEmpty()) {

			Token token = operatorStack.pop();

			if (!token.getValue().equals("("))
				postfixQueue.add(token);
		}
	}

	private void processOperator(Token token) {

		switch (token.getValue()) {

			case "(":

				operatorStack.push(token);
				break;
			case ")":

				while (!operatorStack.isEmpty()) {

					if (operatorStack.peek().getValue().equals("(")) {

						operatorStack.pop();

						if (!operatorStack.isEmpty() && operatorStack.peek().getCategory() == LexicalCategory.FUNCTION)
							postfixQueue.add(operatorStack.pop());

						break;
					}

					postfixQueue.add(operatorStack.pop());
				}

				break;
			case "%":

				Token newToken = new Token(LexicalCategory.FUNCTION, "%");
				operatorStack.push(newToken);
				previousToken = newToken;
				break;
			case "-":

				if (previousToken == null || (previousToken.getCategory() == LexicalCategory.OPERATOR
						&& (!previousToken.getValue().equals(")") || postfixQueue.isEmpty()))) {

					// Don't change the previousToken to allow for double negation eg. "--5"
					operatorStack.push(new Token(LexicalCategory.FUNCTION, "-"));
					break;
				}
			default:

				while (!operatorStack.isEmpty() && !operatorStack.peek().getValue().equals("(")) {

					if (operatorStack.peek().getCategory() == LexicalCategory.FUNCTION) {

						postfixQueue.add(operatorStack.pop());
					} else if (OperatorPrecedence.comparePrecedence(operatorStack.peek().getValue(),
							token.getValue()) >= 0) {

						postfixQueue.add(operatorStack.pop());
					} else
						break;
				}

				operatorStack.push(token);
		}
	}

	private double calcResult() throws Exception {

		double result = 0;

		for (Token token : postfixQueue) {

			switch (token.getCategory()) {

				case NUMBER:

					operandStack.push(Double.parseDouble(token.getValue()));
					break;

				case OPERATOR:

					if (operandStack.size() < 2) {

						throw new Exception("Invalid equation");
					}

					Double right = operandStack.pop();
					Double left = operandStack.pop();

					switch (token.getValue()) {

						case "+":

							operandStack.push(left + right);
							break;
						case "-":

							operandStack.push(left - right);
							break;
						case "×":
						case "*":

							operandStack.push(left * right);
							break;
						case "÷":
						case "/":

							if (Math.abs(right) < 0.0000000001)
								throw new Exception("Divide by zero");

							operandStack.push(left / right);

							break;
						case "^":

							operandStack.push(Math.pow(left, right));
							break;
					}

					break;
				case FUNCTION:

					evaluateFunction(token);
					break;
			}
		}

		if (operandStack.size() == 1)
			result = operandStack.pop();
		else
			throw new Exception("Invalid equation");

		return result;
	}

	private void evaluateFunction(Token token) throws Exception {

		switch (token.getValue()) {

			case "-":

				if (operandStack.size() < 1) {

					throw new Exception("Invalid equation");
				}

				operandStack.push(-operandStack.pop());
				break;
			case "%":

				if (operandStack.size() < 1) {

					throw new Exception("Invalid equation");
				}

				operandStack.push(operandStack.pop() / 100);
				break;
			default:

				throw new Exception("Unknown function: " + token.getValue());
		}
	}
}
