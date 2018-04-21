package com.venmo.cashapp.pojo;

public class User {

	private String name;
	private Wallet wallet;
	private BankAccount account;
	private TransactionUtil tranUtil;
	
	public User(String name, double bankBalance){
		this.name = name;
		account = new BankAccount(bankBalance);
	}
	
	public String getName() {
		return name;
	}
	
	public double getWalletBalance(){
		return wallet.getBalance();
	}
	
	public double getBankBalance(){
		return account.getBalance();
	}
	
	public void addCashToWallet(double amt){
		wallet.addBalance(amt);
	}
	
	public void transferFromWalletToBank(double amt){
		wallet.deductBalance(amt);
		account.addBalance(amt);
		
	}
	public void transferFromBankToWallet(double amt){
		account.deductBalance(amt);
		wallet.addBalance(amt);
		
	}
	public void displayPaymentHistory(){
		tranUtil.displayPaymentHistory();
	}
	
	public void registerPendingPayment(String payee, double amt){
		Transaction trans = new Transaction(this.name,payee, amt);
		tranUtil.createPendingPayment(trans);
	}

	
}
