package com.cisco.tdd.common;

import java.io.Serializable;
import java.math.BigDecimal;

public class LoanRate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6086521407484447764L;

	private String description;

	private BigDecimal shortTermCommercialLoanRate;

	private BigDecimal longTermCommercialLoanRate;

	private BigDecimal shortTermProvidentLoanRate;

	private BigDecimal longTermProvidentLoanRate;

	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	public BigDecimal getShortTermCommercialLoanRate() {
		return shortTermCommercialLoanRate;
	}

	public void setShortTermCommercialLoanRate(
			BigDecimal shortTermCommercialLoanRate) {
		this.shortTermCommercialLoanRate = shortTermCommercialLoanRate;
	}

	public BigDecimal getLongTermCommercialLoanRate() {
		return longTermCommercialLoanRate;
	}

	public void setLongTermCommercialLoanRate(
			BigDecimal longTermCommercialLoanRate) {
		this.longTermCommercialLoanRate = longTermCommercialLoanRate;
	}

	public BigDecimal getShortTermProvidentLoanRate() {
		return shortTermProvidentLoanRate;
	}

	public void setShortTermProvidentLoanRate(
			BigDecimal shortTermProvidentLoanRate) {
		this.shortTermProvidentLoanRate = shortTermProvidentLoanRate;
	}

	public BigDecimal getLongTermProvidentLoanRate() {
		return longTermProvidentLoanRate;
	}

	public void setLongTermProvidentLoanRate(
			BigDecimal longTermProvidentLoanRate) {
		this.longTermProvidentLoanRate = longTermProvidentLoanRate;
	}
}
