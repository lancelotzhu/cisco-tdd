package com.cisco.tdd.server;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import com.cisco.tdd.common.LoanRate;

public class AssertUtils {
	
	public static void assertLoanRate(LoanRate[] loanRates) {
		assertEquals("08年12月23日基准利率", loanRates[0].getDescription());
		assertEquals(new BigDecimal("0.0576"), loanRates[0].getShortTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0594"), loanRates[0].getLongTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0333"), loanRates[0].getShortTermProvidentLoanRate());
		assertEquals(new BigDecimal("0.0387"), loanRates[0].getLongTermProvidentLoanRate());
		assertEquals("08年12月23日利率下限(7折)", loanRates[1].getDescription());
		assertEquals(new BigDecimal("0.0403"), loanRates[1].getShortTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0416"), loanRates[1].getLongTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0333"), loanRates[1].getShortTermProvidentLoanRate());
		assertEquals(new BigDecimal("0.0387"), loanRates[1].getLongTermProvidentLoanRate());
		assertEquals("08年12月23日利率下限(85折)", loanRates[2].getDescription());
		assertEquals(new BigDecimal("0.049"), loanRates[2].getShortTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0505"), loanRates[2].getLongTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0333"), loanRates[2].getShortTermProvidentLoanRate());
		assertEquals(new BigDecimal("0.0387"), loanRates[2].getLongTermProvidentLoanRate());
		assertEquals("08年12月23日利率上限(1.1倍)", loanRates[3].getDescription());
		assertEquals(new BigDecimal("0.0634"), loanRates[3].getShortTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0653"), loanRates[3].getLongTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0333"), loanRates[3].getShortTermProvidentLoanRate());
		assertEquals(new BigDecimal("0.0387"), loanRates[3].getLongTermProvidentLoanRate());
		assertEquals("12年7月6日基准利率", loanRates[loanRates.length-4].getDescription());
		assertEquals(new BigDecimal("0.0640"), loanRates[loanRates.length-4].getShortTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0655"), loanRates[loanRates.length-4].getLongTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0400"), loanRates[loanRates.length-4].getShortTermProvidentLoanRate());
		assertEquals(new BigDecimal("0.0450"), loanRates[loanRates.length-4].getLongTermProvidentLoanRate());
		assertEquals("12年7月6日利率下限（7折）", loanRates[loanRates.length-3].getDescription());
		assertEquals(new BigDecimal("0.0448"), loanRates[loanRates.length-3].getShortTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.04585"), loanRates[loanRates.length-3].getLongTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0400"), loanRates[loanRates.length-3].getShortTermProvidentLoanRate());
		assertEquals(new BigDecimal("0.0450"), loanRates[loanRates.length-3].getLongTermProvidentLoanRate());
		assertEquals("12年7月6日利率下限（85折）", loanRates[loanRates.length-2].getDescription());
		assertEquals(new BigDecimal("0.0544"), loanRates[loanRates.length-2].getShortTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.055675"), loanRates[loanRates.length-2].getLongTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0400"), loanRates[loanRates.length-2].getShortTermProvidentLoanRate());
		assertEquals(new BigDecimal("0.0450"), loanRates[loanRates.length-2].getLongTermProvidentLoanRate());
		assertEquals("12年7月6日利率上限（1.1倍）", loanRates[loanRates.length-1].getDescription());
		assertEquals(new BigDecimal("0.0704"), loanRates[loanRates.length-1].getShortTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.07205"), loanRates[loanRates.length-1].getLongTermCommercialLoanRate());
		assertEquals(new BigDecimal("0.0400"), loanRates[loanRates.length-1].getShortTermProvidentLoanRate());
		assertEquals(new BigDecimal("0.0450"), loanRates[loanRates.length-1].getLongTermProvidentLoanRate());
	}

}
