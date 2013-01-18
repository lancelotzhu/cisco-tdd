package com.cisco.tdd;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.ComponentDriver;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JComboBoxDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JTextFieldDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

public class LoanCalculatorDriver extends JFrameDriver{
	
	public LoanCalculatorDriver(){
		super(new GesturePerformer(), new AWTEventQueueProber(), named(LoanCalculatorUI.MAIN_WINDOW), showingOnScreen());
	}
	public void inputLoanAmount(String loanAmount) {
		textField(LoanCalculatorUI.LOAN_AMOUNT_TEXT_FIELD).typeText(loanAmount);
	}
	public void selectLoanRate(String loanRate) {
		comboBox(LoanCalculatorUI.LOAN_RATE_COMBOBOX).selectItem(0);
	}
	public void selectTerm(String term) {
		comboBox(LoanCalculatorUI.TERM_COMBOBOX).selectItem(0);
	}
	public void doCalculate() {
		button(LoanCalculatorUI.CALCULATE_BUTTON).click();		
	}
	public void shouldDisplayTotalAmount(String expectedTotalAmountText) {
		textField("totalAmountField").hasText(expectedTotalAmountText);
	}
    private JTextFieldDriver textField(String name) {
        return new JTextFieldDriver(this, JTextField.class, ComponentDriver.named(name));
    }
	private JComboBoxDriver comboBox(String name) {
		return new JComboBoxDriver(this, JComboBox.class, ComponentDriver.named(name));
	}
    private JButtonDriver button(String name) {
        return new JButtonDriver(this, JButton.class, ComponentDriver.named(name));
    }
}
