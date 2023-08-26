package codebyte;

public class FXTrading {
	private String currencyPair;
	private String customerName;
	private double amount;
	private double rate;
	private static int tradeCount=1;
	private int tradeNumber;
	public FXTrading(String currencyPair, String customerName, double amount, double rate) {
		this.currencyPair = currencyPair;
		this.customerName = customerName;
		this.amount = amount;
		this.rate = rate;
		this.tradeNumber=tradeCount++;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public String getCustomerName() {
		return customerName;
	}
	public double getAmount() {
		return amount;
	}
	public double getRate() {
		return rate;
	}
	public int getTradeNumber() {
		return tradeNumber;
	}
	
	@Override
	public String toString() {
		double usdToInr=amount*rate;
		return getTradeNumber() + "         " + getCurrencyPair() + "         " + getCustomerName() + "       " + "INR" + (int)usdToInr + "   " + getRate() + ":00";
	}
	
		

}
