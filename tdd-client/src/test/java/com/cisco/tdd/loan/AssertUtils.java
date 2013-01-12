package com.cisco.tdd.loan;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

public class AssertUtils {
	
	private AssertUtils() {		
	}
	
	public static void assertBigDecimal(BigDecimal expected, BigDecimal actual) {
		try {
			assertTrue(expected.compareTo(actual) == 0);
		} catch (AssertionError e) {
			throw new AssertionError("expected " + expected.toPlainString() + 
					" but actually " + actual.toPlainString());
		}
	}

}
