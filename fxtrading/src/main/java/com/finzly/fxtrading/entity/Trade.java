package com.finzly.fxtrading.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trade {

	private int tradeNo;
	private String customerName;
	private String currencyPair;
	private double exchangeRate;
	private double amountToTansfer;
	private double transferredAmount;

	public Trade() {
	}

	public Trade(int tradeNo, String customerName, String currencyPair, double exchangeRate, double amountToTansfer,
			double transferredAmount) {
		super();
		this.tradeNo = tradeNo;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.exchangeRate = exchangeRate;
		this.amountToTansfer = amountToTansfer;
		this.transferredAmount = transferredAmount;
	}

	@Id
	public int getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
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

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getAmountToTansfer() {
		return amountToTansfer;
	}

	public void setAmountToTansfer(double amountToTansfer) {
		this.amountToTansfer = amountToTansfer;
	}

	public double getTransferredAmount() {
		return transferredAmount;
	}

	public void setTransferredAmount(double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}

	@Override
	public String toString() {
		return "Trade [tradeNo=" + tradeNo + ", customerName=" + customerName + ", currencyPair=" + currencyPair
				+ ", exchangeRate=" + exchangeRate + ", amountToTansfer=" + amountToTansfer + ", transferredAmount="
				+ transferredAmount + "]";
	}
}
