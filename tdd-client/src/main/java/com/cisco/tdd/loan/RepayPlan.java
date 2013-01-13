package com.cisco.tdd.loan;

import java.math.BigDecimal;
import java.util.List;

public class RepayPlan {
	
	private List<Installment> installments;

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}
	
	public BigDecimal getTotalRepayAmount() {
		BigDecimal totalRepayAmount = BigDecimal.ZERO;
		for (Installment installment : installments) {
			totalRepayAmount = totalRepayAmount.add(installment.getRepayAmount());
		}
		return totalRepayAmount;
	}
}
