package com.keerthi.SpringProject;

import java.util.HashMap;

public class UserTransactionDetails {
	private static int tradeNo;
	private static String customerName;
	private static String currencyPair;
	private static double amountToTransfer;
	private String rate;
	private static double tranferredAmount=1;
	private static String rateMessage;
	private static String confirmTradeMessage;
	private String Confirm;
	private static HashMap<String,Double> changeRate=new HashMap<>();
	private static boolean flag=false;
	
	
	public UserTransactionDetails() {
		changeRate.put("USDINR",66.00);
		
	}
	
	public UserTransactionDetails(int tradeNo,String customerName, String currencyPair, double amountToTransfer,
			double tranferredAmount, String message, String bookTradeMessage,String confirm) {
		this.tradeNo=tradeNo;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amountToTransfer = amountToTransfer;
		this.rate=rate;
		this.Confirm=confirm;
	}
	
	public int getTradeNo()
	{
		return tradeNo;
	}
	
	public void setTradeNo(int tradeNo)
	{
		this.tradeNo=tradeNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public static String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getAmountToTransfer() {
		return amountToTransfer;
	}

	public void setAmountToTransfer(double amountToTransfer) {
		this.amountToTransfer = amountToTransfer;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public static double getTranferredAmount() {
		return tranferredAmount;
	}

	public void setTranferredAmount(double tranferredAmount) {
		this.tranferredAmount = tranferredAmount;
	}

	public String getRateMessage() {
		return rateMessage;
	}

	public void setMessage(String rateMessage) {
		this.rateMessage = rateMessage;
	}

	public String getConfirmTradeMessage() {
		return confirmTradeMessage;
	}

	public void setConfirmTradeMessage(String bookTradeMessage) {
		this.confirmTradeMessage = bookTradeMessage;
	}

	public String getConfirm() {
		return Confirm;
	}

	public void setConfirm(String confirm) {
		Confirm = confirm;
	}

	@Override
	public String toString() {
		return "UserTransactionDetails [tradeNo=" +tradeNo+ "customerName=" + customerName + ", currencyPair=" + currencyPair
				+ ", amountToTransfer=" + amountToTransfer + ", tranferredAmount=" + tranferredAmount + ", rateMessage="
				+ rateMessage + ", confirmTradeMessage=" + confirmTradeMessage + "]";
	}
	
	public static void bookTrade(UserTransactionDetails tradeDetail) {
		
		int usdToInr=(int) (amountToTransfer*66.0);
		
		//to check valid currency pair
		if(tradeDetail.getCurrencyPair().equalsIgnoreCase("usdinr"))
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		
		tradeDetail.setTranferredAmount(usdToInr);
		
		//To print a rate message if customer want
		if(!tradeDetail.getRate().equalsIgnoreCase("yes"))
		{
			rateMessage="";
		}
		else
		{
			rateMessage="\n You are transferring INR "+getTranferredAmount()+"to "+customerName;
		}
		
		//to book a trade
		if(!tradeDetail.getConfirm().equalsIgnoreCase("book"))
		{
			confirmTradeMessage="";
		}
		else
		{
			confirmTradeMessage="Trade for USDINR has been booked with rate "+changeRate.get("USDINR")+", The amount of Rs."+getTranferredAmount()+" will be transferred in 2 working days to "+customerName+".";
		}
		
	}
	public String displayTrade()
	{
		if(flag) {
			return "Trade Booked \n"+"Trade Number "+ getTradeNo() + "\nCustomer Name: "+ customerName + "\nCurrencyPair: "+currencyPair+"\nAmount to Transafer: "+amountToTransfer+"\n"+rateMessage+"\n"+confirmTradeMessage;
		}
		return "Invalid Currency Pair";
		
	}
	
	

}


