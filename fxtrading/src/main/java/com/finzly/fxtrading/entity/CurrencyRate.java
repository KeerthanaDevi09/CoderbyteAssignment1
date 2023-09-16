package com.finzly.fxtrading.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyRate {

	private int currencyId;
	private String currencyPair;
	private double exchangeRate;

	public CurrencyRate() {
	}

	public CurrencyRate(int currencyId, String currencyPair, double exchangeRate) {
		super();
		this.currencyId = currencyId;
		this.currencyPair = currencyPair;
		this.exchangeRate = exchangeRate;
	}

	@Id
	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
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

	@Override
	public String toString() {
		return "CurrencyRate [currencyId=" + currencyId + ", currencyPair=" + currencyPair + ", exchangeRate="
				+ exchangeRate + "]";
	}

}
