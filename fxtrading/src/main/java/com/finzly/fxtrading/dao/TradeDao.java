package com.finzly.fxtrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtrading.entity.CurrencyRate;
import com.finzly.fxtrading.entity.Trade;

@Repository
public class TradeDao {
																				
	@Autowired
	SessionFactory factory;
	public String addCurrencyRate(CurrencyRate currencyRate) {
		Session session=factory.openSession();
		session.save(currencyRate);
		session.beginTransaction().commit();
		return "Currency Pair and Exchange Rate added successfully";
	}
	
	public List<Trade> getAllTrade() {
		Session session=factory.openSession();
		Criteria criteria = session.createCriteria(Trade.class);
		return criteria.list();
	}

	public void saveTrade(Trade t) {
		Session session=factory.openSession();
		session.save(t);
		session.beginTransaction().commit();
	}

	public List<CurrencyRate> getCurrencyRateDetails(CurrencyRate currencyRate) {
		Session session=factory.openSession();
		Criteria criteria = session.createCriteria(CurrencyRate.class);
		return criteria.list();
	}

	public List<Trade> getAllCurrencyRate() {
		Session session=factory.openSession();
		Criteria criteria = session.createCriteria(CurrencyRate.class);
		return criteria.list();
	}
}
