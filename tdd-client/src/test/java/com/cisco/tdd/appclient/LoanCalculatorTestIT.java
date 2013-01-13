package com.cisco.tdd.appclient;

import static org.easymock.EasyMock.*;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cisco.tdd.common.LoanRate;
import com.cisco.tdd.common.LoanRateFinder;

public class LoanCalculatorTestIT {
	
	private LoanCalculatorDriver driver;
	
	private LoanRateFinder loanRateFinder;
	
	@Before
	public void setUp() {
		driver = new LoanCalculatorDriver();
		loanRateFinder = createMock(LoanRateFinder.class);
		expect(loanRateFinder.listAll()).andReturn(Arrays.asList(new LoanRate[]{
			createLoanRate("12年6月8日基准利率", "0.0665", "0.0680", "0.0420", "0.0470"),
			createLoanRate("12年7月6日基准利率", "0.0640", "0.0655", "0.0400", "0.0450")
		}));
		replay(loanRateFinder);
		LoanCalculator loanCalculator = new LoanCalculator(loanRateFinder);
		loanCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loanCalculator.setName("Loan Calculator");
		loanCalculator.setVisible(true);
	}
	
	@After
	public void tearDown() {
		verify(loanRateFinder);
		driver.dispose();
	}
	
	/**
	 * 公积金贷款
	 * 还款方式：等额本金
	 * 贷款总额：80万
	 * 按揭年数：20年
	 * 利率：12年7月6日基准利率（默认）
	 */
	@Test
	public void testProvidentLoan120706_EqualPrincipal() {
		driver.typeLoanAmount("800000");
		driver.selectRepaymentMethod("等额本金");
		driver.selectTerm(240);
		driver.selectRate("12年7月6日基准利率");
		driver.clickCalculateButton();
		
		driver.displayTotalRepayAmount("1161499.20");
		driver.displayRepayPlan("ProvidentLoan120706_EqualPrincipal.txt");
	}
	
	/**
	 * 公积金贷款
	 * 还款方式：等额本金
	 * 贷款总额：80万
	 * 按揭年数：20年
	 * 利率：12年7月6日基准利率（默认）
	 */
	@Test
	public void testProvidentLoan120706_EqualTotal() {
		driver.typeLoanAmount("800000");
		driver.selectRepaymentMethod("等额本息");
		driver.selectTerm(240);
		driver.selectRate("12年7月6日基准利率");
		driver.clickCalculateButton();
		
		driver.displayTotalRepayAmount("1214688.00");
		driver.displayRepayPlan("ProvidentLoan120706_EqualTotal.txt");
	}

	/**
	 * 公积金贷款
	 * 还款方式：等额本金
	 * 贷款总额：80万
	 * 按揭年数：20年
	 * 利率：12年6月8日利率上限
	 */
	@Test
	public void testProvidentLoan120608_EqualPrincipal() {
		driver.typeLoanAmount("300000");
		driver.selectRepaymentMethod("等额本息");
		driver.selectTerm(120);
		driver.selectRate("12年6月8日基准利率");
		driver.clickCalculateButton();
		
		driver.displayTotalRepayAmount("376579.20");
		driver.displayRepayPlan("ProvidentLoan120608_EqualTotal.txt");
	}
	
	private LoanRate createLoanRate(String description, String shortTermCommercialLoanRate,
			String longTermCommercialLoanRate, String shortTermProvidentLoanRate,
			String longTermProvidentLoanRate) {
		LoanRate loanRate = new LoanRate();
		loanRate.setDescription(description);
		loanRate.setShortTermCommercialLoanRate(new BigDecimal(shortTermCommercialLoanRate));
		loanRate.setLongTermCommercialLoanRate(new BigDecimal(longTermCommercialLoanRate));
		loanRate.setShortTermProvidentLoanRate(new BigDecimal(shortTermProvidentLoanRate));
		loanRate.setLongTermProvidentLoanRate(new BigDecimal(longTermProvidentLoanRate));
		return loanRate;
	}
}
