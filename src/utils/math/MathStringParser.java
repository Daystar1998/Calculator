package utils.math;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

import utils.strings.StringTokenizer;
import utils.strings.Token;

/*
 * Class for parsing and evaluating a math equation
 */
public class MathStringParser {

	private StringTokenizer tokenizer = new StringTokenizer();
	private Queue<Token> postfixQueue = new ArrayDeque<Token>();
	private Deque<Token> operatorStack = new ArrayDeque<Token>();

	public double evaluateEquation(String equation) throws Exception {

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
		}

		while (!operatorStack.isEmpty()) {

			Token token = operatorStack.pop();

			if (!token.getValue().equals("("))
				postfixQueue.add(token);
		}
	}

	private void processOperator(Token token) {
		
		// TODO Unary operators '-' and '%'

		switch (token.getValue()) {

			case "(":

				operatorStack.push(token);
				break;
			case ")":

				while (!operatorStack.isEmpty()) {

					if (operatorStack.peek().getValue().equals("(")) {

						operatorStack.pop();
						break;
					}

					postfixQueue.add(operatorStack.pop());
				}

				break;
			default:

				while (!operatorStack.isEmpty() && !operatorStack.peek().getValue().equals("(")) {

					if (OperatorPrecedence.comparePrecedence(operatorStack.peek().getValue(), token.getValue()) >= 0) {

						postfixQueue.add(operatorStack.pop());
					} else
						break;
				}

				operatorStack.push(token);
		}
	}

	private double calcResult() throws Exception {

		double result = 0;

		Deque<Double> operandStack = new ArrayDeque<Double>();

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

							operandStack.push(left / right);
							break;
						case "^":

							operandStack.push(Math.pow(left, right));
							break;
					}
				case FUNCTION:
					// TODO
					break;
			}
		}

		if (operandStack.size() == 1)
			result = operandStack.pop();
		else
			throw new Exception("Invalid equation");

		return result;
	}
}
