package com.cisco.tdd.loan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class EqualTotalPayment implements RepaymentMethod {

	@Override
	public RepayPlan calculate(BigDecimal loanAmount, int term, BigDecimal loanRate) {
		RepayPlan repayPlan = new RepayPlan();
		List<Installment> installments = new ArrayList<Installment>();		
		BigDecimal monthlyRate = loanRate.divide(
				Constants.MONTHES_IN_ONE_YEAR, 
				Constants.CNY_CALCULATE_PRECISION, 
				RoundingMode.HALF_EVEN);
		BigDecimal repayAmount = loanAmount.multiply(monthlyRate).multiply(
				BigDecimal.ONE.add(monthlyRate).pow(term)).divide(						
				BigDecimal.ONE.add(monthlyRate).pow(term).subtract(BigDecimal.ONE),
				Constants.CNY_CALCULATE_PRECISION, RoundingMode.HALF_EVEN).setScale(
				Constants.CNY_DISPLAY_PRECISION, RoundingMode.HALF_EVEN);
		Installment installment = new Installment();
		installment.setRepayAmount(repayAmount);
		installments.add(installment);
		repayPlan.setInstallments(installments);
		return repayPlan;
	}

}
