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
		BigDecimal monthlyRate = loanRate.divide(new BigDecimal("12"), 10, RoundingMode.HALF_EVEN);
		BigDecimal repayAmount = loanAmount.multiply(monthlyRate).multiply(
				BigDecimal.ONE.add(monthlyRate).pow(term)).divide(						
				BigDecimal.ONE.add(monthlyRate).pow(term).subtract(BigDecimal.ONE),
				10, RoundingMode.HALF_EVEN).setScale(2, RoundingMode.HALF_EVEN);
		Installment installment = new Installment();
		installment.setRepayAmount(repayAmount);
		installments.add(installment);
		repayPlan.setInstallments(installments);
		return repayPlan;
	}

}
