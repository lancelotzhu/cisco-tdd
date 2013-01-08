package com.cisco.tdd.server;

import java.util.List;

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
		List<LoanRate> loanRateList = target.listAll();
		LoanRate[] loanRates = loanRateList.toArray(new LoanRate[0]);
		AssertUtils.assertLoanRate(loanRates);
	}

}
