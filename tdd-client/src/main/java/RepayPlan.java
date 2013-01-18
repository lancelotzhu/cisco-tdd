import java.math.BigDecimal;
import java.util.List;

public class RepayPlan {
	private BigDecimal totalAmount;

	private List<BigDecimal> monthlyPayments;

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setMonthlyPayments(List<BigDecimal> monthlyPayments) {
		this.monthlyPayments = monthlyPayments;
	}

	public BigDecimal getTotalAmount() {

		return totalAmount;
	}

	public List<BigDecimal> getMonthlyPayments() {
		return monthlyPayments;
	}

}
