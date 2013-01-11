package com.cisco.tdd.loan;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class InterestCalculatorTest {

	private InstallmentCalculator target = null;

	@Test
	public void testEqualPrincipalWithSimpleLoanRate() {
		target = new InstallmentCalculator();		
		RepayPlan repayplan = target.calculate(
				new BigDecimal("300000"), 
				12,
				new BigDecimal("0.042"));
		BigDecimal[] expected = new BigDecimal[] { 
				new BigDecimal("26050"),
				new BigDecimal("25962.5"), 
				new BigDecimal("25875"), 
				new BigDecimal("25787.5"),
				new BigDecimal("25700"), 
				new BigDecimal("25612.5"), 
				new BigDecimal("25525"),
				new BigDecimal("25437.5"),
				new BigDecimal("25350"),
				new BigDecimal("25262.5"),
				new BigDecimal("25175"),
				new BigDecimal("25087.5") 
		};
		for (int i = 0; i < 12; i++) {
			Installment installment = repayplan.getInstallments().get(i);
			try {
				assertTrue(expected[i].compareTo(installment.getRepayAmount()) == 0);
			} catch (AssertionError e) {
				throw new AssertionError("expected " + expected[i] + " but actually " + 
						installment.getRepayAmount().toPlainString() + " at index " + i);
			}
		}
	}

	@Test
	public void testEqualPrincipalWithHardLoanRate() {
		target = new InstallmentCalculator();		
		RepayPlan repayplan = target.calculate(
				new BigDecimal("300000"), 
				12,
				new BigDecimal("0.04"));
		BigDecimal[] expected = new BigDecimal[] { 
				new BigDecimal("26000"),
				new BigDecimal("25916.67"), 
				new BigDecimal("25833.33"), 
				new BigDecimal("25750"),
				new BigDecimal("25666.67"), 
				new BigDecimal("25583.33"), 
				new BigDecimal("25500"),
				new BigDecimal("25416.67"),
				new BigDecimal("25333.33"),
				new BigDecimal("25250"),
				new BigDecimal("25166.67"),
				new BigDecimal("25083.33") 
		};
		for (int i = 0; i < 12; i++) {
			Installment installment = repayplan.getInstallments().get(i);
			try {
				assertTrue(expected[i].compareTo(installment.getRepayAmount()) == 0);
			} catch (AssertionError e) {
				throw new AssertionError("expected " + expected[i] + " but actually " + 
						installment.getRepayAmount() + " at index " + i);
			}
		}
	}
	
	@Test
	public void testEqualPrincipalWithHardLoanAmount() {
		target = new InstallmentCalculator();		
		RepayPlan repayplan = target.calculate(
				new BigDecimal("500000"), 
				12,
				new BigDecimal("0.04"));
		BigDecimal[] expected = new BigDecimal[] { 
				new BigDecimal("43333.33"),
				new BigDecimal("43194.44"), 
				new BigDecimal("43055.56"), 
				new BigDecimal("42916.67"),
				new BigDecimal("42777.78"), 
				new BigDecimal("42638.89"), 
				new BigDecimal("42500"),
				new BigDecimal("42361.11"),
				new BigDecimal("42222.22"),
				new BigDecimal("42083.33"),
				new BigDecimal("41944.44"),
				new BigDecimal("41805.56") 
		};
		for (int i = 0; i < 12; i++) {
			Installment installment = repayplan.getInstallments().get(i);
			try {
				assertTrue(expected[i].compareTo(installment.getRepayAmount()) == 0);
			} catch (AssertionError e) {
				throw new AssertionError("expected " + expected[i] + " but actually " + 
						installment.getRepayAmount() + " at index " + i);
			}
		}
	}
}
