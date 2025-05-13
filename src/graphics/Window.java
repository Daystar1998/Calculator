package graphics;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.gbl.Fill;
import utils.gbl.GBConstraints;
import utils.math.MathStringParser;

/*
 * Main window class. UI layout mimics KDE's KCalc program
 */
public class Window {

	private ArrayList<String> history;
	private MathStringParser mathParser;

	private JFrame frame;
	private JTextField displayTextField;
	private JTextField infoTextField;
	private JPanel inputPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		history = new ArrayList<String>();
		mathParser = new MathStringParser();

		frame = new JFrame("Calculator");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel basePanel = createBasePanel();
		frame.setContentPane(basePanel);

		JPanel basicInputPanel = createBasicInputPanel();
		inputPanel.add(basicInputPanel, new GBConstraints(0, 0).fill(Fill.BOTH));

		JPanel specialInputPanel = createSpecialInputPanel();
		inputPanel.add(specialInputPanel, new GBConstraints(1, 0).fill(Fill.BOTH));
	}

	private JPanel createBasePanel() {

		JPanel basePanel = new JPanel();
		basePanel.setLayout(new GridBagLayout());

		// Display panel

		JPanel displayPanel = new JPanel(new GridBagLayout());
		basePanel.add(displayPanel, new GBConstraints(0, 0).size(6, 2).fill(Fill.BOTH));

		displayTextField = new JTextField();
		displayTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		displayPanel.add(displayTextField, new GBConstraints(0, 0).fill(Fill.BOTH));

		infoTextField = new JTextField();
		infoTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		infoTextField.setEditable(false);
		displayPanel.add(infoTextField, new GBConstraints(0, 1).fill(Fill.BOTH));

		// Input panel

		inputPanel = new JPanel(new GridBagLayout());
		basePanel.add(inputPanel, new GBConstraints(0, 2).size(1, 5).fill(Fill.BOTH));

		return basePanel;
	}

	private JPanel createBasicInputPanel() {

		JPanel basicInputPanel = new JPanel(new GridBagLayout());

		// Row 0

		JButton buttonPercent = new JButton("%");
		buttonPercent.setToolTipText("Percent");
		buttonPercent.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "%");
		});
		basicInputPanel.add(buttonPercent, new GBConstraints(0, 0).fill(Fill.BOTH));

		JButton buttonDivision = new JButton("÷");
		buttonDivision.setToolTipText("Division");
		buttonDivision.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "÷");
		});
		basicInputPanel.add(buttonDivision, new GBConstraints(1, 0).fill(Fill.BOTH));

		JButton buttonMultiplication = new JButton("×");
		buttonMultiplication.setToolTipText("Multiplication");
		buttonMultiplication.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "×");
		});
		basicInputPanel.add(buttonMultiplication, new GBConstraints(2, 0).fill(Fill.BOTH));

		JButton buttonSubtraction = new JButton("-");
		buttonSubtraction.setToolTipText("Minus");
		buttonSubtraction.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "-");
		});
		basicInputPanel.add(buttonSubtraction, new GBConstraints(3, 0).fill(Fill.BOTH));

		// Row 1

		JButton buttonSeven = new JButton("7");
		buttonSeven.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "7");
		});
		basicInputPanel.add(buttonSeven, new GBConstraints(0, 1).fill(Fill.BOTH));

		JButton buttonEight = new JButton("8");
		buttonEight.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "8");
		});
		basicInputPanel.add(buttonEight, new GBConstraints(1, 1).fill(Fill.BOTH));

		JButton buttonNine = new JButton("9");
		buttonNine.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "9");
		});
		basicInputPanel.add(buttonNine, new GBConstraints(2, 1).fill(Fill.BOTH));

		JButton buttonAddition = new JButton("+");
		buttonAddition.setToolTipText("Plus");
		buttonAddition.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "+");
		});
		basicInputPanel.add(buttonAddition, new GBConstraints(3, 1).size(1, 2).fill(Fill.BOTH));

		// Row 2

		JButton buttonFour = new JButton("4");
		buttonFour.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "4");
		});
		basicInputPanel.add(buttonFour, new GBConstraints(0, 2).fill(Fill.BOTH));

		JButton buttonFive = new JButton("5");
		buttonFive.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "5");
		});
		basicInputPanel.add(buttonFive, new GBConstraints(1, 2).fill(Fill.BOTH));

		JButton buttonSix = new JButton("6");
		buttonSix.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "6");
		});
		basicInputPanel.add(buttonSix, new GBConstraints(2, 2).fill(Fill.BOTH));

		// Row 3

		JButton buttonOne = new JButton("1");
		buttonOne.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "1");
		});
		basicInputPanel.add(buttonOne, new GBConstraints(0, 3).fill(Fill.BOTH));

		JButton buttonTwo = new JButton("2");
		buttonTwo.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "2");
		});
		basicInputPanel.add(buttonTwo, new GBConstraints(1, 3).fill(Fill.BOTH));

		JButton buttonThree = new JButton("3");
		buttonThree.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "3");
		});
		basicInputPanel.add(buttonThree, new GBConstraints(2, 3).fill(Fill.BOTH));

		JButton buttonEqual = new JButton("=");
		buttonEqual.setToolTipText("Result");
		buttonEqual.addActionListener(e -> {

			solveEquation(displayTextField.getText());
		});
		basicInputPanel.add(buttonEqual, new GBConstraints(3, 3).size(1, 2).fill(Fill.BOTH));

		// Row 4

		JButton buttonZero = new JButton("0");
		buttonZero.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "0");
		});
		basicInputPanel.add(buttonZero, new GBConstraints(0, 4).size(2, 1).fill(Fill.BOTH));

		JButton buttonDecimal = new JButton(".");
		buttonDecimal.setToolTipText("Decimal point");
		buttonDecimal.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + ".");
		});
		basicInputPanel.add(buttonDecimal, new GBConstraints(2, 4).fill(Fill.BOTH));

		return basicInputPanel;
	}

	private JPanel createSpecialInputPanel() {

		JPanel specialInputPanel = new JPanel(new GridBagLayout());

		// TODO Row zero shift button

		JButton buttonClear = new JButton("C");
		buttonClear.setToolTipText("Clear");
		buttonClear.addActionListener(e -> {

			displayTextField.setText("");
			infoTextField.setText("");
		});
		specialInputPanel.add(buttonClear, new GBConstraints(0, 1).fill(Fill.BOTH));

		JButton buttonClearAll = new JButton("AC");
		buttonClearAll.setToolTipText("Clear all");
		buttonClearAll.addActionListener(e -> {

			displayTextField.setText("");
			infoTextField.setText("");
			history.clear();
		});
		specialInputPanel.add(buttonClearAll, new GBConstraints(0, 2).fill(Fill.BOTH));

		JButton buttonOpeningParenthesis = new JButton("(");
		buttonOpeningParenthesis.setToolTipText("Open Parenthesis");
		buttonOpeningParenthesis.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + "(");
		});
		specialInputPanel.add(buttonOpeningParenthesis, new GBConstraints(0, 3).fill(Fill.BOTH));

		JButton buttonClosingParenthesis = new JButton(")");
		buttonClosingParenthesis.setToolTipText("Close Parenthesis");
		buttonClosingParenthesis.addActionListener(e -> {

			displayTextField.setText(displayTextField.getText() + ")");
		});
		specialInputPanel.add(buttonClosingParenthesis, new GBConstraints(0, 4).fill(Fill.BOTH));

		JButton buttonChangeSign = new JButton("+/-");
		buttonChangeSign.setToolTipText("Change sign");
		buttonChangeSign.addActionListener(e -> {

			solveEquation("-(" + displayTextField.getText() + ")");
		});
		specialInputPanel.add(buttonChangeSign, new GBConstraints(0, 5).fill(Fill.BOTH));

		return specialInputPanel;
	}

	private void solveEquation(String equation) {

		String trimmedEquation = equation.trim();

		if (trimmedEquation.isEmpty()) {

			infoTextField.setText("");
			return;
		}

		try {

			double result = mathParser.evaluateEquation(trimmedEquation);

			DecimalFormat decimalFormat = new DecimalFormat("0");
			decimalFormat.setMaximumFractionDigits(340); // Maximum allowed
			String resultString = decimalFormat.format(result);

			history.add(trimmedEquation + "=" + resultString);

			displayTextField.setText(resultString);
			infoTextField.setForeground(null);
			infoTextField.setText("");
		} catch (Exception e) {

			displayTextField.setText(trimmedEquation);
			infoTextField.setForeground(Color.RED);
			infoTextField.setText(e.getMessage());
		}
	}
}
