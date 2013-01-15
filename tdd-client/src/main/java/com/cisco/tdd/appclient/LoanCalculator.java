package com.cisco.tdd.appclient;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cisco.tdd.common.LoanRate;
import com.cisco.tdd.common.LoanRateFinder;
import com.cisco.tdd.loan.DefaultLoanRateFinder;
import com.cisco.tdd.loan.EqualPrincipalPayment;
import com.cisco.tdd.loan.EqualTotalPayment;
import com.cisco.tdd.loan.Installment;
import com.cisco.tdd.loan.LoanTerm;
import com.cisco.tdd.loan.RepayPlan;
import com.cisco.tdd.loan.RepaymentMethod;

public class LoanCalculator extends JFrame {

	private static final long serialVersionUID = 8860015484218274806L;
	
	private static final Insets DEFAULT_INSETS = new Insets(2,2,2,2);
	
	public LoanCalculator(LoanRateFinder loanRateFinder) {
		super("Loan Calculator");
		setLayout(new GridBagLayout());
		
		JLabel lblLoanAmount = new JLabel("贷款总额：");
		add(lblLoanAmount, constraint(0, 0));
		final JTextField tfLoanAmount = new JTextField(12);
		tfLoanAmount.setName("loanAmount");
		add(tfLoanAmount, constraint(1, 0));
		
		JLabel lblRepaymentMethod = new JLabel("还款方式：");
		ButtonGroup bgRepaymentMethod = new ButtonGroup();
		add(lblRepaymentMethod, constraint(0, 1));
		final JRadioButton rbEqualPrincipal = new JRadioButton("等额本金");
		rbEqualPrincipal.setName("equalPrincipal");
		add(rbEqualPrincipal, constraint(1, 1));
		bgRepaymentMethod.add(rbEqualPrincipal);
		final JRadioButton rbEqualTotal = new JRadioButton("等额本息");
		rbEqualTotal.setName("equalTotal");
		add(rbEqualTotal, constraint(2, 1));
		bgRepaymentMethod.add(rbEqualTotal);
		
		JLabel lblTerm = new JLabel("按揭年数：");
		add(lblTerm, constraint(0, 2));
		final JComboBox cbTerm = new JComboBox();
		cbTerm.setName("term");
		for (int i = 1; i <= 20; i++) {
			cbTerm.addItem(new LoanTerm(i*12));
		}
		cbTerm.addItem(new LoanTerm(300));
		cbTerm.addItem(new LoanTerm(360));
		add(cbTerm, constraint(1, 2));
		
		JLabel lblRate = new JLabel("利率：");
		add(lblRate, constraint(0, 3));
		final JComboBox cbRate = new JComboBox();
		cbRate.setName("rate");
		List<LoanRate> loanRates = loanRateFinder.listAll();
		for (LoanRate loanRate : loanRates) {
			cbRate.addItem(loanRate);
		}
		add(cbRate, constraint(1, 3));

		JButton btnCalculate = new JButton("开始计算");
		btnCalculate.setName("calculate");
		add(btnCalculate, constraint(1, 4));
		
		JLabel lblTotalRepayAmount = new JLabel("还款总额：");
		add(lblTotalRepayAmount, constraint(0, 5));
		final JTextField tfTotalRepayAmount = new JTextField(12);
		tfTotalRepayAmount.setEditable(false);
		tfTotalRepayAmount.setName("totalRepayAmount");
		add(tfTotalRepayAmount, constraint(1, 5));
		JLabel lblCurrency = new JLabel("元");
		add(lblCurrency, constraint(2, 5));

		JLabel lblRepayPlan = new JLabel("月均金额：");
		add(lblRepayPlan, constraint(0, 6));
		final JTextArea taRepayPlan = new JTextArea();
		taRepayPlan.setEditable(false);		
		taRepayPlan.setName("repayPlan");
		taRepayPlan.setRows(5);
		taRepayPlan.setWrapStyleWord(true);
		JScrollPane spRepayPlan = new JScrollPane(taRepayPlan); 
		add(spRepayPlan, constraint(1, 6));

		btnCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RepaymentMethod repaymentMethod;
				if (rbEqualTotal.isSelected()) {
					repaymentMethod = new EqualTotalPayment();
				} else {
					repaymentMethod = new EqualPrincipalPayment();
				}
				RepayPlan repayPlan = repaymentMethod.calculate(
						new BigDecimal(tfLoanAmount.getText()), 
						Integer.valueOf(((LoanTerm)cbTerm.getSelectedItem()).getValue()), 
						((LoanRate)cbRate.getSelectedItem()).getLongTermProvidentLoanRate());
				tfTotalRepayAmount.setText(repayPlan.getTotalRepayAmount().toPlainString());
				StringBuffer sb = new StringBuffer();
				if (1 == repayPlan.getInstallments().size()) {
					sb.append(repayPlan.getInstallments().iterator().next().getRepayAmount());
					sb.append("(元)\n");
				} else {
					for (int i = 0; i < repayPlan.getInstallments().size(); i++) {
						Installment installment = repayPlan.getInstallments().get(i);
						sb.append(i + 1);
						sb.append("月,");
						sb.append(installment.getRepayAmount());
						sb.append("(元)\n");
					}
				}
				taRepayPlan.setText(sb.toString());
				pack();
			}
		});

		pack();
	}
	
	@SuppressWarnings("serial")
	private Object constraint(final int x, final int y) {
		return new GridBagConstraints() {{
            gridx = x;
            gridy = y;
            weightx = 1;
            weighty = 1;
            insets = DEFAULT_INSETS;
            fill = BOTH;
        }};
	}
	
	public static void main(String... args) {
		LoanCalculator loanCalculator = new LoanCalculator(new DefaultLoanRateFinder());
		loanCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loanCalculator.setName("Loan Calculator");
		loanCalculator.setVisible(true);
	}

}
