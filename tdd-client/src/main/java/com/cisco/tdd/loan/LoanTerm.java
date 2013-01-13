package com.cisco.tdd.loan;

public class LoanTerm {
	
	private int value;

	public LoanTerm(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value / 12 + "年 (" + value + "期）";
	}
	
}
