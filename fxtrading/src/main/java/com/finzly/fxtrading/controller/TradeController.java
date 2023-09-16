package com.finzly.fxtrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtrading.entity.CurrencyRate;
import com.finzly.fxtrading.entity.Trade;
import com.finzly.fxtrading.service.TradeService;

@RestController
@RequestMapping("/trade")
public class TradeController {
	
	@Autowired
	TradeService tradeService;

	// To add a currency pair and rate
	@PostMapping("/add-currency-pair")
	public String addCurrencyRate(@RequestBody CurrencyRate currencyRate) {
		return tradeService.addCurrencyRate(currencyRate);

	}

	// To get all the trade details
	@GetMapping("/get-all-trades")
	public List<Trade> getAllTrade() {
		return tradeService.getAllTrade();
	}

	// To book a new trade
	@PostMapping("/book-trade")
	public String bookTrade(CurrencyRate currencyRate, @RequestBody Trade trade) {
		return tradeService.bookTrade(currencyRate, trade);

	}
	
	//To get all currency pair with rates
	@GetMapping("/get-all-currency-rate")
	public List<Trade> getAllCurrencyRate() {
		return tradeService.getAllCurrencyRate();
	}
}
