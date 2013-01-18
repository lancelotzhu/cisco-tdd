package com.cisco.tdd;

import static java.awt.Font.BOLD;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoanCalculatorUI extends JFrame{

	public static final String LOAN_AMOUNT_TEXT_FIELD = "loanAmountTextField";
	public static final String TOTAL_AMOUNT_FIELD = "totalAmountField";
	public static final String MAIN_WINDOW = "loanRateWindow";
	public static final String LOAN_RATE_COMBOBOX = "loanRateField";
	public static final String TERM_COMBOBOX = "termField";
	public static final String CALCULATE_BUTTON = "calculateButton";
	private JTextField totalAmountFiled;
	final Insets defaultInsets = new Insets(2,2,2,2);
	
	public LoanCalculatorUI() {
        super("LoanCalculator");
        totalAmountFiled = new JTextField(12);
        totalAmountFiled.setName(TOTAL_AMOUNT_FIELD);
        totalAmountFiled.setEditable(false);
        totalAmountFiled.setHorizontalAlignment(JTextField.RIGHT);
        totalAmountFiled.setFont(totalAmountFiled.getFont().deriveFont(32f).deriveFont(BOLD));
        
        setLayout(new GridBagLayout());
        
        add(totalAmountFiled, new GridBagConstraints() {{
            gridx = 0;
            gridy = 0;
            gridwidth = REMAINDER;
            insets = defaultInsets;
            fill = BOTH;
        }});
        
        addFieldWithLabel("loanAmount", LOAN_AMOUNT_TEXT_FIELD, 1);
        addComboWithLabelAndDefaultValue("loanRate", LOAN_RATE_COMBOBOX, 2, "0.0486");
        addComboWithLabelAndDefaultValue("term", TERM_COMBOBOX, 3, "10 Years");
        
        JButton calculateButton = new JButton("calculate");
        calculateButton.setName(CALCULATE_BUTTON);
		add(calculateButton, new GridBagConstraints() {{
            gridx = 1;
            gridy = 4;
            weightx = 1;
            weighty = 1;
            insets = defaultInsets;
            fill = BOTH;
        }});
		//
		//calculateButton
        
        pack();
	}

	private void addComboWithLabelAndDefaultValue(String labelDisplayText, String componentName, int positionIndex, String defaultItem) {
		JComboBox combobox = new JComboBox();
		combobox.addItem(defaultItem);
		combobox.setName(componentName);
        addSomethingWithLabel(labelDisplayText, combobox, positionIndex);
	}

	private void addFieldWithLabel(String labelDisplayText, String componentName, final int positionIndex) {
        JTextField field = new JTextField();
        field.setName(componentName);
        addSomethingWithLabel(labelDisplayText, field, positionIndex);
	}
	
	private void addSomethingWithLabel(String labelDisplayText, JComponent component, final int  positionIndex) {
		JLabel loanAmountLabel = new JLabel(labelDisplayText);
		add(loanAmountLabel, new GridBagConstraints() {{
            gridx = 1;
            gridy = positionIndex;
            weightx = 1;
            weighty = 1;
            insets = defaultInsets;
            fill = BOTH;
        }});
        
        
		add(component, new GridBagConstraints() {{
            gridx = 2;
            gridy = positionIndex;
            weightx = 1;
            weighty = 1;
            insets = defaultInsets;
            fill = BOTH;
        }});
	}

	public static void main(String... args) {
		LoanCalculatorUI calculator = new LoanCalculatorUI();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setName(MAIN_WINDOW);
        calculator.setVisible(true);
	}

}
