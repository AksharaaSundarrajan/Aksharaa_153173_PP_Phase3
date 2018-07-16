package com.cg.mypaymentapp.test;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;


public class TestClass {

	
	WalletService service;
	
	@Before
	public void initData(){
		 /*Map<String,Customer> data= new HashMap<String, Customer>();*/
		 Customer cust1=new Customer("Amit", "9900112212",new Wallet(new BigDecimal(9000)));
		 Customer cust2=new Customer("Ajay", "9963242422",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("Yogini", "9922950519",new Wallet(new BigDecimal(7000)));
				
		 /*data.put("9900112212", cust1);
		 data.put("9963242422", cust2);	
		 data.put("9922950519", cust3);	*/
			service= new WalletServiceImpl();
			
	}
	//1
	@Test(expected=InvalidInputException.class)
	public void  testShowBalanceInvalidNumber()
	{
		String mobileNumber = "9898989";
		service.showBalance(mobileNumber);
	}
	//2
	@Test
	public void  testShowBalanceValidNumber()
	{
		Customer cust = new Customer();
		String mobileNumber = "9963242422";
		cust = service.showBalance(mobileNumber);
		System.out.println(cust);
	}
	//22
	@Test
	public void createAccountValid()
	{
		
		String name ="Aksharaa";
		String number = "9963242412";
		BigDecimal amount = new BigDecimal("1234.02");
		service.createAccount(name, number, amount);
		
	}
	//3
	@Test(expected=InvalidInputException.class)
	public void createAccountInvalidName1()
	{
		
		String name =" ";
		String number = "9963242422";
		BigDecimal amount = new BigDecimal("1234.02");
		service.createAccount(name, number, amount);
		
	}
	//4
	@Test(expected=NullPointerException.class)
	public void createAccountInvalidName2()
	{
		
		String name =null;
		String number = "9963242422";
		BigDecimal amount = new BigDecimal("1234.02");
		service.createAccount(name, number, amount);
		
	}
	
	//5
	@Test(expected=InvalidInputException.class)
	public void createAccountInvalidMobileNo()
	{
		
		String name ="Aksharaa";
		String number = "99632";
		BigDecimal amount = new BigDecimal("1234.02");
		service.createAccount(name, number, amount);
		
	}
	//6
	@Test(expected=InvalidInputException.class)
	public void createAccountInvalidAmount1()
	{
		
		String name ="Aksharaa";
		String number = "9963242422";
		BigDecimal amount = new BigDecimal("0.0");
		service.createAccount(name, number, amount);
		
	}	
	
	//7
	//Check!!!!
	/*@Test(expected=InvalidInputException.class)
	public void createAccountInvalidAmount2()
	{
		Customer cust = new Customer();
		String name ="Aksharaa";
		String number = "9963242422";
		BigDecimal amount = new BigDecimal("twenty");
		cust = service.createAccount(name, number, amount);
		
	}*/
	//20
	@Test(expected=InvalidInputException.class)
	public void createAccountInvalidAmount3()
	{
		
		String name ="Aksharaa";
		String number = "9963242422";
		BigDecimal amount = new BigDecimal("100.00");
		service.createAccount(name, number, amount.negate());
		
	}
	//23
	@Test
	public void fundTransferValid()
	{
		//Customer cust = new Customer();
		String sourceMobile ="9900112212";
		String targetMobile = "9963242422";
		service.fundTransfer(sourceMobile, targetMobile, new BigDecimal("10.00"));
		
	}
	//8
	@Test(expected=InvalidInputException.class)
	public void fundTransferInvalidSourceMobile()
	{
		String sourceMobile ="909090";
		String targetMobile = "9963242422";
		BigDecimal amount = new BigDecimal("1000.00");
		service.fundTransfer(sourceMobile, targetMobile, amount);
		
	}
	//9
	@Test(expected=InvalidInputException.class)
	public void fundTransferInvalidTargetMobile()
	{
		String sourceMobile ="9963242422";
		String targetMobile = "909090";
		BigDecimal amount = new BigDecimal("1000.00");
		service.fundTransfer(sourceMobile, targetMobile, amount);
		
	}
	//10
	@Test(expected=InvalidInputException.class)
	public void fundTransferInvalidAmount()
	{
		String sourceMobile ="9922950519";
		String targetMobile = "9963242422";
		BigDecimal amount = new BigDecimal("0");
		service.fundTransfer(sourceMobile, targetMobile, amount);
		
	}
	//21
	@Test(expected=InvalidInputException.class)
	public void fundTransferInvalidAmount2()
	{
		String sourceMobile ="9922950519";
		String targetMobile = "9963242422";
		BigDecimal amount = new BigDecimal("100");
		service.fundTransfer(sourceMobile, targetMobile, amount.negate());
		
	}
	//11
	@Test(expected=InvalidInputException.class)
	public void fundTransferSourceEqualsTarget()
	{
		String sourceMobile ="9922950519";
		String targetMobile = "9922950519";
		BigDecimal amount = new BigDecimal("100.00");
		service.fundTransfer(sourceMobile, targetMobile, amount);
		
	}
	//12
	@Test(expected=InsufficientBalanceException.class)
	public void fundTransferInsufficientBalance()
	{
		
		String sourceMobile ="9922950519";
		String targetMobile = "9963242422";
		BigDecimal amount = new BigDecimal("1000000.00");
		service.fundTransfer(sourceMobile, targetMobile, amount);
		
	}
	//24
	@Test
	public void depositAmountValid()
	{
		String mobile ="9963242422";
		BigDecimal amount = new BigDecimal("100.00");
		service.depositAmount(mobile, amount);
	}
	//13
	@Test(expected=InvalidInputException.class)
	public void depositAmountInvalidNumber()
	{
		
		String mobile ="909090";
		BigDecimal amount = new BigDecimal("100.00");
		service.depositAmount(mobile, amount);
	}
	//14
	@Test(expected=InvalidInputException.class)
	public void depositAmountInvalidAmount1()
	{
		
		String mobile ="9963242422";
		BigDecimal amount = new BigDecimal("0.00");
		service.depositAmount(mobile, amount);
	}
	//15
	@Test(expected=InvalidInputException.class)
	public void depositAmountInvalidAmount2()
	{
		
		String mobile ="9963242422";
		service.depositAmount(mobile, new BigDecimal(100).negate());
	}
	//25 ERROR
	@Test
	public void withdrawAmountValid()
	{
		
		String mobile ="9963242422";
		BigDecimal amount = new BigDecimal("10.00");
		service.withdrawAmount(mobile, amount);
	}
	//16
	@Test(expected=InvalidInputException.class)
	public void withdrawAmountInvalidNumber()
	{
		
		String mobile ="909090";
		BigDecimal amount = new BigDecimal("100.00");
		service.withdrawAmount(mobile, amount);
	}
	//17
	@Test(expected=InvalidInputException.class)
	public void withdrawAmountInvalidAmount1()
	{
		
		String mobile ="9963242422";
		BigDecimal amount = new BigDecimal("0.00");
		service.withdrawAmount(mobile, amount);
	}
	//18
	@Test(expected=InvalidInputException.class)
	public void withdrawAmountInvalidAmount2()
	{
		
		String mobile ="9963242422";
		BigDecimal amount = new BigDecimal("100.00");
		service.withdrawAmount(mobile, amount.negate());
	}
	//19
	@Test(expected=InsufficientBalanceException.class)
	public void withdrawAmountInsufficientBalance()
	{
		
		String mobile ="9963242422";
		BigDecimal amount = new BigDecimal("1000000");
		service.withdrawAmount(mobile, amount);
	}
	

}
