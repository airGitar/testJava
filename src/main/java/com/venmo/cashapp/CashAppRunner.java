package com.venmo.cashapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/*** CashAppRunner implements CommandLineRunner and is used for Command Line input processing from the user ***/

@Component
public class CashAppRunner implements CommandLineRunner{

	@Autowired
	CashAppManager cashAppManager;
	
	@Override
	public void run(String... args) throws Exception {

		try{
			//Initializing the Cash App System to have two users A and B. 
			cashAppManager.initCashUserBase();
			
			System.out.println();
			System.out.println(">> Please request a command in the following formats >>");
			System.out.println(" GetBalance <your username>");
			System.out.println(" ViewPayments <your username>");
			System.out.println(" AddCash <your username> <amount>");
			System.out.println(" RequestCash <your username> <payer username> <amount>");
			System.out.println(" MakePayment <transaction id>");
			System.out.println();
			System.out.println(">> Press any key to continue, Q/q to Quit >>");

			/* Exit if user enters 'Q/q' */
			if("Q".equalsIgnoreCase(System.console().readLine())){
				return;
			}
			processUserInput();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	private void processUserInput() throws Exception{

		System.out.println();
		
		String userInput=System.console().readLine();
		String[] uInputArray = userInput.split(" ");
		
		do{
		
			if("GetBalance".equalsIgnoreCase(uInputArray[0])){
				cashAppManager.viewWalletBalance(uInputArray[1]);
			} else if ("ViewPayments".equalsIgnoreCase(uInputArray[0])){
				cashAppManager.viewRecentPayments(uInputArray[1]);
			} else if ("AddCash".equalsIgnoreCase(uInputArray[0])){
				cashAppManager.addCashtoUserWallet(uInputArray[1], 25.0);
			} else if ("RequestCash".equalsIgnoreCase(uInputArray[0])){
				cashAppManager.requestPayment(uInputArray[2], uInputArray[1], 10.0);
			}
		
		} while (!("Q".equalsIgnoreCase(userInput=System.console().readLine())));

	}

}
