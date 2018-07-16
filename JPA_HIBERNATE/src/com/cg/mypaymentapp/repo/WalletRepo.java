package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;

public interface WalletRepo {

	public boolean save(Customer customer);
	public Customer findOne(String mobileNo);
	void setTransactions(Transaction transaction);
	List<Transaction> getTransactions(String mobilenumber);
	void updateBalance(Customer cust);
	public void commitTransaction();
	public void beginTransaction();
}
