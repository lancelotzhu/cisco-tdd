package com.cisco.tdd.loan;

import java.math.BigDecimal;
import java.util.List;

public class RepayPlan {
	
	private List<Installment> installments;
	
	private BigDecimal totalRepayAmount;

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

	public BigDecimal getTotalRepayAmount() {
		return totalRepayAmount;
	}

	public void setTotalRepayAmount(BigDecimal totalRepayAmount) {
		this.totalRepayAmount = totalRepayAmount;
	}
	
}
