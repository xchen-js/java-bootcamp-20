package homework6;

public class SalesReport {
	private String month;
	private long amount;
	
	public SalesReport (String month, long amount) {
		this.month = month;
		this.amount = amount;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}
