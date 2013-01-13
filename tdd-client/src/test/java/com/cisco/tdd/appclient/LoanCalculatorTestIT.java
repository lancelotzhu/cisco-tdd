package com.cisco.tdd.appclient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoanCalculatorTestIT {
	
	private LoanCalculatorDriver target;
	
	@Before
	public void setUp() {
		LoanCalculator.main();
		target = new LoanCalculatorDriver();
	}
	
	@After
	public void tearDown() {
		target.dispose();
	}
	
	/**
	 * 公积金贷款
	 * 还款方式：等额本金
	 * 贷款总额：80万
	 * 按揭年数：20年
	 */
	@Test
	public void testCurrentProvidentLoan() {
		target.typeLoanAmount("800000");
		target.selectRepaymentMethod("等额本金");
		target.selectTerm(240);
		target.clickCalculateButton();
		
		target.displayTotalRepayAmount("1161499.20");
		target.displayRepayPlan("CurrentProvidentLoan_RepayPlan.txt");
	}
	
}
