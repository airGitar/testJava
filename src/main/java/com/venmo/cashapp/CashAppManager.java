package com.venmo.cashapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.venmo.cashapp.pojo.User;

@Component
public class CashAppManager {

	
	private Map<String, User> cashAppUsers = new HashMap<>();
	
	
	public void initCashUserBase(){
		User userA = new User("A",10000);
		User userB = new User("B",5000);
		cashAppUsers.put(userA.getName(), userA);
		cashAppUsers.put(userB.getName(), userB);
		
	}
	public void addCashtoUserWallet(String username, double amt){
		
		if(cashAppUsers.containsKey(username)){
			User user = cashAppUsers.get(username);
			user.addCashToWallet(amt);
			
		}else{
			System.out.println("User"+ username+" does not exist");
		}
		
	}
	public void viewWalletBalance(String username){
		
		if(cashAppUsers.containsKey(username)){
			User user = cashAppUsers.get(username);
			System.out.println("Wallet Balance: "+user.getWalletBalance());
			
		}else{
			System.out.println("User"+ username+" does not exist");
		}
		
	}
	
	public void requestPayment(String payer, String payee, double amt){
		
		if(!cashAppUsers.containsKey(payer)){ 
			System.out.println("User"+ payer+" does not exist");
			return;
		}
		if(!cashAppUsers.containsKey(payee)){ 
			System.out.println("User"+ payee+" does not exist");
			return;
		}
		
		User user = cashAppUsers.get(payer);
		user.registerPendingPayment(payee, amt);
			
	}
	public void fulfilPayment(String transId){
		
		
	}
	public void viewRecentPayments(String username){
		
		if(cashAppUsers.containsKey(username)){
			User user = cashAppUsers.get(username);
			user.displayPaymentHistory();
			
		}else{
			System.out.println("User"+ username+" does not exist");
		}
		
	}
}
