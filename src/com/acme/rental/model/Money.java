package com.acme.rental.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Money {
	
	private final BigDecimal amount;
	private final String currency;
	
	
	// Main constructor with validation.
	public Money (BigDecimal amount, String currency) {
		if (amount == null)
			throw new IllegalArgumentException("amount is null");
		if (currency == null || currency.isBlank())
			throw new  IllegalArgumentException("Currency is blank");
		if (amount.signum() < 0 )
			throw new IllegalArgumentException("amount < 0");
			
		
	//// normalise amount and currency
		this.amount = amount.setScale(2, RoundingMode.HALF_UP); // 2 decimal places
		this.currency = currency.toUpperCase();    // e.g EUR
		
		
	}
	
	
	public static Money of(String amount, String currency) {
		return new Money (new BigDecimal(amount), currency);
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return amount + " " + currency; //example 12.50 EUR
	}
	
	
	
	

}
