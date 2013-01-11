package com.cisco.tdd.loan;

import java.math.BigDecimal;

public interface RepaymentMethod {

	/**
	 * Calculate the repay plan.
	 * 
	 * @param loanAmount
	 * @param term
	 * @param loanRate
	 * @return
	 */
	RepayPlan calculate(BigDecimal loanAmount, int term, BigDecimal loanRate);
	
}