package com.cisco.tdd.appclient;

import static org.hamcrest.Matchers.equalTo;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JComboBoxDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JRadioButtonDriver;
import com.objogate.wl.swing.driver.JTextComponentDriver;
import com.objogate.wl.swing.driver.JTextFieldDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

public class LoanCalculatorDriver extends JFrameDriver {
	
	@SuppressWarnings("unchecked")
	public LoanCalculatorDriver() {
		super(new GesturePerformer(), new AWTEventQueueProber(), 
				named("Loan Calculator"), showingOnScreen());
	}

	public void typeLoanAmount(String loanAmount) {
		textField("loanAmount").typeText(loanAmount);
	}

	public void selectRepaymentMethod(String repaymentMethod) {
		if ("等额本金".equals(repaymentMethod)) {
			radioButton("equalPrincipal").click();
		} else if ("等额本息".equals(repaymentMethod)) {
			radioButton("equalTotal").click();
		}
	}

	public void selectTerm(int term) {
		int index = 0;
		if (term <= 240) {
			index = term / 12 - 1;
		} else if (term == 300) {
			index = 20;
		} else if (term == 360) {
			index = 21;
		}
		comboBox("term").selectItem(index);
	}

	public void selectRate(String rate) {
		comboBox("rate").selectItem(withLabel(rate));
	}

	public void clickCalculateButton() {
		button("calculate").click();
	}

	@SuppressWarnings("unchecked")
	public void displayTotalRepayAmount(String totalRepayAmount) {
		JTextFieldDriver text = new JTextFieldDriver(this, JTextField.class, named("totalRepayAmount"));
		text.hasText(equalTo(totalRepayAmount));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayRepayPlan(String repayPlanFile) {
		JTextComponentDriver text = new JTextComponentDriver(this, JTextArea.class, named("repayPlan"));
		text.hasText(equalTo(readRepayPlan(repayPlanFile)));
	}

	private String readRepayPlan(String repayPlanFile) {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(repayPlanFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is)); 
		StringBuffer sb = new StringBuffer();
		try {
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {  
	            sb.append(line);
	            sb.append("\n");
	        } 
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	private JRadioButtonDriver radioButton(String name) {
		return new JRadioButtonDriver(this, JRadioButton.class, named(name));
	}
	
	@SuppressWarnings("unchecked")
	private JComboBoxDriver comboBox(String name) {
		return new JComboBoxDriver(this, JComboBox.class, named(name));
	}
	
	@SuppressWarnings("unchecked")
	private JTextFieldDriver textField(String name) {
		return new JTextFieldDriver(this, JTextField.class, named(name));
	}
	
    @SuppressWarnings("unchecked")
	private JButtonDriver button(String name) {
        return new JButtonDriver(this, JButton.class, named(name));
    }
    
    private Matcher<? extends Component> withLabel(final String text) {
    	return new BaseMatcher<JLabel>() {
			@Override
			public boolean matches(Object obj) {
				return text.equals(((JLabel)obj).getText());
			}
			@Override
			public void describeTo(Description description) {
			}
			
		};
    }

}
