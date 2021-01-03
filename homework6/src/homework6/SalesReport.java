package homework6;

import java.time.YearMonth;

public class SalesReport {
	private YearMonth month;
	private Integer amount;
	
	public SalesReport (YearMonth month, Integer amount) {
		this.month = month;
		this.amount = amount;
	}
	
	public YearMonth getMonth() {
		return month;
	}
	public void setMonth(YearMonth month) {
		this.month = month;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
