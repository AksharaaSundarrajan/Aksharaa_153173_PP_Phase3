package com.cg.mypaymentapp.pl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class Client {
	WalletService wService;
	
	Client()
	{
		wService = new WalletServiceImpl();
	}
	public void menu()
	{
		System.out.println("Welcome! Please select an option: ");
		System.out.println("1. Create an account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			Customer customer = new Customer();
			System.out.println("Please enter your name: ");
			String name = sc.next();
			System.out.println("Please enter your mobile number");
			String mobileno = sc.next();
			System.out.println("Please enter the amount you want to deposit");
			BigDecimal amount= sc.nextBigDecimal();
			customer = wService.createAccount(name, mobileno, amount);
			System.out.println("Your details are: ");
			System.out.println("Name: "+customer.getName());
			System.out.println("Mobile Number: "+customer.getMobileNo());
			System.out.println("Amount Deposited: "+customer.getWallet().getBalance());
			
			break;
		case 2:
			System.out.println("Enter your mobile number:");
			String number = sc.next();
			customer = wService.showBalance(number);
			while(true) {
			System.out.println("Welcome back "+customer.getName()+"!");
			System.out.println("What would you like to do today? (Select an option)");
			System.out.println("1. Fund Transfer");
			System.out.println("2. Deposit Amount");
			System.out.println("3. Withdraw Amount");
			System.out.println("4. Show Balance");
			System.out.println("5. Get transaction details");
			System.out.println("6. Exit");
			int choice1 = sc.nextInt();
			switch (choice1) {
			case 1:
				System.out.println("Enter the number of the transferee");
				String num2 = sc.next();
				System.out.println("Enter the transfer amount");
				BigDecimal amt = sc.nextBigDecimal();
				customer=wService.fundTransfer(number, num2, amt);
				System.out.println(customer);
				break;
			case 2:
				System.out.println("Enter amount");
				BigDecimal amt1 = sc.nextBigDecimal();
				customer = wService.depositAmount(number, amt1);
				System.out.println(customer);
				break;
			case 3:
				System.out.println("Enter amount");
				BigDecimal amt2 = sc.nextBigDecimal();
				customer = wService.withdrawAmount(number, amt2);
				System.out.println(customer);
				break;
			case 4:
				customer =wService.showBalance(number);
				System.out.println(customer);
			case 5:
				List<Transaction> transactions =wService.getTransactionDetails(number);
				Iterator it = transactions.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				
				break;
			case 6:
				System.out.println("Logging out");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
		case 3:
			System.out.println("You are leaving the app. Goodbye.");
			System.exit(0);
			break;
		
		default:
			System.out.println("Not a valid option.");
			break;
		}
	}
	
	public static void main( String[] args )
	{
	
		Client client = new Client();
		while(true)
		{
			client.menu();
		}
	}
}
