package codebyte;

public class BookTrade extends FXTrading{

	public BookTrade(String currencyPair, String customerName, double amount, double rate) {
		super(currencyPair, customerName, amount, rate);
	}
	public void displayDetails()
	{
		double usdToInr=getAmount()*getRate();
		System.out.println("You are transferring INR "+usdToInr+" to "+getCustomerName()+" (The rate was "+(int)getRate()+".00 )\n");
	}
	public void bookTrade()
	{
		double usdToInr=getAmount()*getRate();
		System.out.println("Trade for " + getCurrencyPair() + " has been booked with rate " +getRate() + ". The amount of INR " + usdToInr +" will be transferred in 2 working days to " + getCustomerName()+"\n"); 
	}
	


}
