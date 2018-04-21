package com.venmo.cashapp.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

@Component
public class TransactionUtil {
	
		
	private Map<String, Transaction> paymentHistory = new HashMap<>();
	private Map<String, Transaction> pendingPayments = new HashMap<>();
	
	public TransactionUtil(){

	}
	public void displayPaymentHistory(){
		
		System.out.println("Payment History:");
		for(Entry payment : paymentHistory.entrySet()){
			
			Transaction transaction = (Transaction)payment.getValue();
			System.out.println("Payment "+payment.getKey()+" made to User "+ transaction.getPayee());
		}
		
	}
	public void createPendingPayment(Transaction transaction){

		pendingPayments.put(transaction.getTransactionId(), transaction);
	}
	
	public void fulfilPendingPayment(String transId){

		if(pendingPayments.containsKey(transId)){
			Transaction transaction = pendingPayments.get(transId);
			
			pendingPayments.remove(transId);
			paymentHistory.put(transId, transaction);
			
			
		}else{
			System.out.println("No pending transaction "+ transId);
		}
	}

	
	
}
