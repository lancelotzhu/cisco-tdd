package com.cisco.tdd.loan;

import java.util.List;

public class RepayPlan {
	
	private List<Installment> installments;

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

}
