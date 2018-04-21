package com.venmo.cashapp.pojo;

public class BankAccount {

	double balance;
	
	public BankAccount(double balance){
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public void addBalance(double amt){
	
		balance += amt;
		
	}
	public void deductBalance(double amt){
		if(!hasSufficientFunds(amt)){
			System.out.println("Insufficient funds in Bank Account!");
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
