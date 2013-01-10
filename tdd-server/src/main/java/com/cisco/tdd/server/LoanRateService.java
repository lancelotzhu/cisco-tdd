package com.cisco.tdd.server;

import java.math.BigDecimal;

import com.cisco.tdd.common.LoanRate;

public class LoanRateService {
	
	public LoanRate[] listAll() {
		return new LoanRate[] {
			createLoanRate("08年12月23日基准利率", "0.0576", "0.0594", "0.0333", "0.0387"),
			createLoanRate("08年12月23日利率下限(7折)", "0.0403", "0.0416", "0.0333", "0.0387"),
			createLoanRate("08年12月23日利率下限(85折)", "0.049", "0.0505", "0.0333", "0.0387"),
			createLoanRate("08年12月23日利率上限(1.1倍)", "0.0634", "0.0653", "0.0333", "0.0387"),
			createLoanRate("10年10月20日基准利率", "0.0596", "0.0614", "0.035", "0.0405"),
			createLoanRate("10年10月20日利率下限(7折)", "0.04172", "0.04298", "0.035", "0.0405"),
			createLoanRate("10年10月20日利率下限(85折)", "0.05066", "0.05218", "0.035", "0.0405"),
			createLoanRate("10年10月20日利率上限(1.1倍)", "0.06556", "0.06754", "0.035", "0.0405"),
			createLoanRate("10年12月26日基准利率", "0.0622", "0.0640", "0.0375", "0.0430"),
			createLoanRate("10年12月26日利率下限(7折)", "0.04354", "0.0448", "0.0375", "0.0430"),
			createLoanRate("10年12月26日利率上限(1.1倍)", "0.06842", "0.0704", "0.0375", "0.0430"),
			createLoanRate("11年2月9日基准利率", "0.0645", "0.0660", "0.0400", "0.0450"),
			createLoanRate("11年2月9日利率下限(7折)", "0.04515", "0.04620", "0.0400", "0.0450"),
			createLoanRate("11年2月9日利率下限(85折)", "0.054825", "0.0561", "0.0400", "0.0450"),
			createLoanRate("11年2月9日利率上限(1.1倍)", "0.07095", "0.0726", "0.0400", "0.0450"),
			createLoanRate("11年4月5日基准利率", "0.0665", "0.0680", "0.0420", "0.0470"),
			createLoanRate("11年4月5日利率下限（7折）", "0.04655", "0.0476", "0.0420", "0.0470"),
			createLoanRate("11年4月5日利率下限（85折）", "0.056525", "0.0578", "0.0420", "0.0470"),
			createLoanRate("11年4月5日利率上限（1.1倍）", "0.07315", "0.0748", "0.0420", "0.0470"),
			createLoanRate("11年7月6日基准利率", "0.0690", "0.0705", "0.0445", "0.0490"),
			createLoanRate("11年7月6日利率下限（7折）", "0.0483", "0.04935", "0.0445", "0.0490"),
			createLoanRate("11年7月6日利率下限（85折）", "0.05865", "0.059925", "0.0445", "0.0490"),
			createLoanRate("11年7月6日利率上限（1.1倍）", "0.0759", "0.07755", "0.0445", "0.0490"),
			createLoanRate("12年6月8日基准利率", "0.0665", "0.0680", "0.0420", "0.0470"),
			createLoanRate("12年6月8日利率下限（7折）", "0.04655", "0.0476", "0.0420", "0.0470"),
			createLoanRate("12年6月8日利率下限（85折）", "0.056525", "0.0578", "0.0420", "0.0470"),
			createLoanRate("12年6月8日利率上限（1.1倍）", "0.07315", "0.0748", "0.0420", "0.0470"),
			createLoanRate("12年7月6日基准利率", "0.0640", "0.0655", "0.0400", "0.0450"),
			createLoanRate("12年7月6日利率下限（7折）", "0.0448", "0.04585", "0.0400", "0.0450"),
			createLoanRate("12年7月6日利率下限（85折）", "0.0544", "0.055675", "0.0400", "0.0450"),
			createLoanRate("12年7月6日利率上限（1.1倍）", "0.0704", "0.07205", "0.0400", "0.0450")
		};
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
