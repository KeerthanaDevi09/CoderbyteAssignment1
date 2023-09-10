package com.keerthi.SpringProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fxtrade")
public class FxTradeController {
	private List<UserTransactionDetails> tradeDetails=new ArrayList<>();
	
	//Book the trade
	@PostMapping("/book_trade")
	public String bookTrades(@RequestBody UserTransactionDetails tradeDetail) {
		tradeDetail.bookTrade(tradeDetail);
		if(tradeDetail.isBookOrCancle());
			tradeDetails.add(tradeDetail);
		return "Trade Received : "+tradeDetail.displayTrade().toString();
		
	}
	
	
	//Print all the trades
	@GetMapping("/print_trade")
	public List<UserTransactionDetails> getAllTrades()
	{
		return tradeDetails;
	}
}
