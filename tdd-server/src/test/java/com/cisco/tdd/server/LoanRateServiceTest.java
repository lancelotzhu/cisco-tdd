package com.cisco.tdd.server;

import org.junit.Before;
import org.junit.Test;

import com.cisco.tdd.common.LoanRate;

public class LoanRateServiceTest {
	
	private LoanRateService target;

	@Before
	public void setUp() throws Exception {
		target = new LoanRateService();
	}

	@Test
	public void testListAllLoanRates() {
		LoanRate[] loanRates = target.listAll();
		AssertUtils.assertLoanRate(loanRates);
	}

}
