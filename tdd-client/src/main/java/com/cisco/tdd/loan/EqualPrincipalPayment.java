package com.cisco.tdd.loan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class EqualPrincipalPayment implements RepaymentMethod {

	public RepayPlan calculate(BigDecimal loanAmount, int term, BigDecimal loanRate) {
		RepayPlan repayPlan = new RepayPlan();
		List<Installment> installments = new ArrayList<Installment>();
		BigDecimal unrepayPrincipal = new BigDecimal(loanAmount.toString());
		for (int i = 0; i < term; i++) {
			Installment installment = new Installment();
			BigDecimal repayPrincipal = loanAmount.divide(new BigDecimal(term), 
					Constants.CNY_CALCULATE_PRECISION, RoundingMode.HALF_EVEN);			
			BigDecimal repayInterest = unrepayPrincipal.multiply(loanRate).divide(
					Constants.MONTHES_IN_ONE_YEAR, 
					Constants.CNY_CALCULATE_PRECISION, 
					RoundingMode.HALF_EVEN);			
			BigDecimal repayAmount = repayPrincipal.add(repayInterest);
			installment.setRepayAmount(repayAmount.setScale(
					Constants.CNY_DISPLAY_PRECISION, RoundingMode.HALF_EVEN));
			installments.add(installment);
			unrepayPrincipal = unrepayPrincipal.subtract(repayPrincipal);		
		}
		repayPlan.setInstallments(installments);		
		return repayPlan;
	}

}
