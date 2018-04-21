package com.venmo.cashapp.pojo;

import java.util.UUID;

public class Transaction {

	private String transactionId;
	private String payer;
	private String payee;
	private double amt;
	
	public Transaction(String payer, String payee, double amt){
		UUID uuid = UUID.randomUUID();
		this.transactionId = uuid.toString();
		
		this.payer = payer;
		this.payee = payee;
		this.amt = amt;
		
	}
	public String getTransactionId() {
		return transactionId;
	}
	public String getPayer() {
		return payer;
	}
	public String getPayee() {
		return payee;
	}
	public double getAmt() {
		return amt;
	}

}
