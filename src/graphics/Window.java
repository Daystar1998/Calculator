package graphics;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.gbl.Fill;
import utils.gbl.GBConstraints;

/*
 * Main window class. UI layout mimics KDE's KCalc program
 */
public class Window {

	private JFrame frame;
	private JTextField inputTextField;
	private JTextField resultTextField;
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		inputTextField = new JTextField();
		inputTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		displayPanel.add(inputTextField, new GBConstraints(0, 0).fill(Fill.BOTH));
		
		resultTextField = new JTextField();
		resultTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		resultTextField.setEditable(false);
		displayPanel.add(resultTextField, new GBConstraints(0, 1).fill(Fill.BOTH));
		
		// Input panel
		
		inputPanel = new JPanel(new GridBagLayout());
		basePanel.add(inputPanel, new GBConstraints(0, 2).size(1, 5).fill(Fill.BOTH));
		
		return basePanel;
	}
	
	private JPanel createBasicInputPanel() {
		
		JPanel basicInputPanel = new JPanel(new GridBagLayout());
		
		// Row 0
		
		JButton buttonPercent = new JButton("%");
		basicInputPanel.add(buttonPercent, new GBConstraints(0, 0).fill(Fill.BOTH));
		
		JButton buttonDivision = new JButton("÷");
		basicInputPanel.add(buttonDivision, new GBConstraints(1, 0).fill(Fill.BOTH));
		
		JButton buttonMultiplication = new JButton("×");
		basicInputPanel.add(buttonMultiplication, new GBConstraints(2, 0).fill(Fill.BOTH));
		
		JButton buttonSubtraction = new JButton("-");
		basicInputPanel.add(buttonSubtraction, new GBConstraints(3, 0).fill(Fill.BOTH));
		
		// Row 1
		
		JButton buttonSeven = new JButton("7");
		basicInputPanel.add(buttonSeven, new GBConstraints(0, 1).fill(Fill.BOTH));
		
		JButton buttonEight = new JButton("8");
		basicInputPanel.add(buttonEight, new GBConstraints(1, 1).fill(Fill.BOTH));
		
		JButton buttonNine = new JButton("9");
		basicInputPanel.add(buttonNine, new GBConstraints(2, 1).fill(Fill.BOTH));
		
		JButton buttonAddition = new JButton("+");
		basicInputPanel.add(buttonAddition, new GBConstraints(3, 1).size(1, 2).fill(Fill.BOTH));
		
		// Row 2
		
		JButton buttonFour = new JButton("4");
		basicInputPanel.add(buttonFour, new GBConstraints(0, 2).fill(Fill.BOTH));
		
		JButton buttonFive = new JButton("5");
		basicInputPanel.add(buttonFive, new GBConstraints(1, 2).fill(Fill.BOTH));
		
		JButton buttonSix = new JButton("6");
		basicInputPanel.add(buttonSix, new GBConstraints(2, 2).fill(Fill.BOTH));

		// Row 3
		
		JButton buttonOne = new JButton("1");
		basicInputPanel.add(buttonOne, new GBConstraints(0, 3).fill(Fill.BOTH));
		
		JButton buttonTwo = new JButton("2");
		basicInputPanel.add(buttonTwo, new GBConstraints(1, 3).fill(Fill.BOTH));
		
		JButton buttonThree = new JButton("3");
		basicInputPanel.add(buttonThree, new GBConstraints(2, 3).fill(Fill.BOTH));
		
		JButton buttonEqual = new JButton("=");
		basicInputPanel.add(buttonEqual, new GBConstraints(3, 3).size(1, 2).fill(Fill.BOTH));
		
		// Row 4
		
		JButton buttonZero = new JButton("0");
		basicInputPanel.add(buttonZero, new GBConstraints(0, 4).size(2, 1).fill(Fill.BOTH));
		
		JButton buttonDecimal = new JButton(".");
		basicInputPanel.add(buttonDecimal, new GBConstraints(2, 4).fill(Fill.BOTH));
		
		return basicInputPanel;
	}
	
	private JPanel createSpecialInputPanel() {
		
		JPanel specialInputPanel = new JPanel(new GridBagLayout());
		
		// TODO Row zero shift button
		
		JButton buttonClear = new JButton("C");
		specialInputPanel.add(buttonClear, new GBConstraints(0, 1).fill(Fill.BOTH));
		
		JButton buttonClearAll = new JButton("AC");
		specialInputPanel.add(buttonClearAll, new GBConstraints(0, 2).fill(Fill.BOTH));
		
		JButton buttonOpeningParenthesis = new JButton("(");
		specialInputPanel.add(buttonOpeningParenthesis, new GBConstraints(0, 3).fill(Fill.BOTH));
		
		JButton buttonClosingParenthesis = new JButton(")");
		specialInputPanel.add(buttonClosingParenthesis, new GBConstraints(0, 4).fill(Fill.BOTH));
		
		JButton buttonChangeSign = new JButton("+/-");
		specialInputPanel.add(buttonChangeSign, new GBConstraints(0, 5).fill(Fill.BOTH));
		
		return specialInputPanel;
	}
}
