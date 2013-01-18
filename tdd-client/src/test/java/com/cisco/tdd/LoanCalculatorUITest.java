package com.cisco.tdd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoanCalculatorUITest {
	
	private LoanCalculatorDriver target;
	
	@Before 
	public void setUp() {
		LoanCalculatorUI.main();
		target = new LoanCalculatorDriver();
	}
	
	@After
	public void tearDown() {
		target.dispose();
	}
	
	@Test
	public void testSimpleLoanWithFixedRate() {
		target.inputLoanAmount("120000");
		target.selectLoanRate("0.0486");
		target.selectTerm("120");
		target.doCalculate();
		target.shouldDisplayTotalAmount("149403.00");
	}

}
