package com.finzly.fxtrading.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.finzly.fxtrading.dao.TradeDao;
import com.finzly.fxtrading.entity.CurrencyRate;
import com.finzly.fxtrading.entity.Trade;
import com.finzly.fxtrading.exception.CurrencyPairAlreadyExistsException;
import com.finzly.fxtrading.exception.CurrencyPairNotValidException;
import com.finzly.fxtrading.exception.DataNotFoundException;

@Service
public class TradeService {

	@Autowired
	TradeDao tradeDao;

	public String addCurrencyRate(CurrencyRate currencyRate) {
		List<CurrencyRate> list = tradeDao.getCurrencyRateDetails(currencyRate);
		if (currencyRate.getCurrencyPair() == null || currencyRate.getExchangeRate() == 0.0) {
			throw new DataNotFoundException("Data not found" + HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			for (CurrencyRate l : list) {
				if (l.getCurrencyPair().equalsIgnoreCase(currencyRate.getCurrencyPair())) {
					throw new CurrencyPairAlreadyExistsException(
							"Currency pair " + currencyRate.getCurrencyPair() + " is already exist");
				}
			}
		}
		return tradeDao.addCurrencyRate(currencyRate);

	}

	public List<Trade> getAllTrade() {
		return tradeDao.getAllTrade();
	}

	public String bookTrade(CurrencyRate currencyRate, Trade trade) {
		List<CurrencyRate> list = tradeDao.getCurrencyRateDetails(currencyRate);
		if (trade.getAmountToTansfer() == 0.0 || trade.getCustomerName() == null || trade.getCurrencyPair() == null) {
			throw new DataNotFoundException("Data not found" + HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			double transferredamount = 1;
			String currencypair = trade.getCurrencyPair();
			double amount = trade.getAmountToTansfer();
			String name = trade.getCustomerName();
			double rate = 0.0;
			boolean flag = false;
			for (CurrencyRate l : list) {
				if (l.getCurrencyPair().equalsIgnoreCase(currencypair)) //compare the currency pair with the currency table
				{
					transferredamount = l.getExchangeRate() * amount;
					rate = l.getExchangeRate();
					flag = true;
				}
			}
			if (!flag) {
				throw new CurrencyPairNotValidException("Invalid Currency pair");
			} else {
				//set the values using object
				Trade t = new Trade();
				t.setCurrencyPair(currencypair);
				t.setAmountToTansfer(amount);
				t.setCustomerName(name);
				t.setTransferredAmount(transferredamount);
				t.setExchangeRate(rate);
				tradeDao.saveTrade(t);
				return "Trade Booked Successfully" + HttpStatus.CREATED;
			}
		}
	}

	public List<Trade> getAllCurrencyRate() {
		return tradeDao.getAllCurrencyRate();
	}
}
