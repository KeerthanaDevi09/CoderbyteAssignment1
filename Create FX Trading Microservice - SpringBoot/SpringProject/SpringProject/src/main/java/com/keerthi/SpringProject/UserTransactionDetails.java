package com.keerthi.SpringProject;

import java.util.HashMap;

public class UserTransactionDetails {
	private int tradeNo;
	private String customerName;
	private String currencyPair;
	private double amountToTransfer;
	private String rate;
	private double tranferredAmount=1;
	private String rateMessage;
	private String confirmTradeMessage;
	private String Confirm;
	private static HashMap<String,Double> changeRate=new HashMap<>();
	private boolean flag=false;
	private boolean bookOrCancle=false;
	private boolean printRateOrNot=false;
	
	
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

	public String getCurrencyPair() {
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

	public double getTranferredAmount() {
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
	
	public boolean isBookOrCancle() {
		return bookOrCancle;
	}

	public boolean isPrintRateOrNot() {
		return printRateOrNot;
	}


	@Override
	public String toString() {
		return "UserTransactionDetails [tradeNo=" +tradeNo+ "customerName=" + customerName + ", currencyPair=" + currencyPair
				+ ", amountToTransfer=" + amountToTransfer + ", tranferredAmount=" + tranferredAmount + ", rateMessage="
				+ rateMessage + ", confirmTradeMessage=" + confirmTradeMessage + "]";
	}
	
	public void bookTrade(UserTransactionDetails tradeDetail) {
		
		try {
		
			int usdToInr=(int) (getAmountToTransfer()*66.0);
			
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
				printRateOrNot=false;
				rateMessage="";
			}
			else
			{
				printRateOrNot=true;
				rateMessage="\n"+ "You are transferring INR "+getTranferredAmount()+"to "+customerName;
			}
			
			//To book a trade
			if(!tradeDetail.getConfirm().equalsIgnoreCase("book"))
			{
				bookOrCancle=false;
				confirmTradeMessage="Trade Cancled";
			}
			else
			{
				bookOrCancle=true;
				confirmTradeMessage="Trade for USDINR has been booked with rate "+changeRate.get("USDINR")+", The amount of Rs."+getTranferredAmount()+" will be transferred in 2 working days to "+customerName+".";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public String displayTrade()
	{
		if(!flag)
		{
			return "Invalid Currency Pair";
		}
		else if(flag && bookOrCancle) {
			return "Trade Booked \n"+"Trade Number "+ getTradeNo() + "\nCustomer Name: "+ customerName + "\nCurrencyPair: "+currencyPair+"\nAmount to Transafer: "+amountToTransfer+"\n"+rateMessage+"\n"+confirmTradeMessage;
		}
		else if(flag && printRateOrNot && !bookOrCancle)
		{
			return rateMessage + "\n" +"Trade Cancle";
		}
		return "Trade Cancle";	
	}
}


