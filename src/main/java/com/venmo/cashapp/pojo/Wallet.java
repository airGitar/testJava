package com.venmo.cashapp.pojo;

public class Wallet {

	double balance;
	
	public double getBalance() {
		return balance;
	}

	public void addBalance(double amt){
	
		balance += amt;
		
	}
	public void deductBalance(double amt){
		if(!hasSufficientFunds(amt)){
			System.out.println("Insufficient funds in Wallet!");
			return;
		}
		balance -= amt;
		
	}
	private boolean hasSufficientFunds(double amt){
		
		if(balance >= amt){
			return true;
		}
		return false;
	}
}
