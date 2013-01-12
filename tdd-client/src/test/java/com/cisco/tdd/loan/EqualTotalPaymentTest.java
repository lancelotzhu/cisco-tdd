package com.cisco.tdd.loan;

import static com.cisco.tdd.loan.AssertUtils.assertBigDecimal;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class EqualTotalPaymentTest {
	private RepaymentMethod target = null;

	@Before
	public void setUp() {
		target = new EqualTotalPayment();
	}

	@Test
	public void testSimpleLoanRate() {
		RepayPlan repayPlan = target.calculate(
				new BigDecimal("300000"), 
				12,
				new BigDecimal("0.042"));
		Installment installment = repayPlan.getInstallments().iterator().next();
		assertBigDecimal(new BigDecimal("25572.39"), installment.getRepayAmount());
	}

	@Test
	public void testComplexLoanRate() {
		RepayPlan repayPlan = target.calculate(
				new BigDecimal("300000"), 
				12,
				new BigDecimal("0.04"));
		Installment installment = repayPlan.getInstallments().iterator().next();
		assertBigDecimal(new BigDecimal("25544.97"), installment.getRepayAmount());
	}
	
	@Test
	public void testComplexLoanAmount() {
		RepayPlan repayPlan = target.calculate(
				new BigDecimal("500000"), 
				12,
				new BigDecimal("0.04"));
		Installment installment = repayPlan.getInstallments().iterator().next();
		assertBigDecimal(new BigDecimal("42574.95"), installment.getRepayAmount());
	}
}
