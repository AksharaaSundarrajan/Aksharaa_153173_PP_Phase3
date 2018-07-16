package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.util.DBUtil;

public class WalletRepoImpl implements WalletRepo{
	Customer customer = new Customer();
	int id =0;
	private EntityManager entityManager;
	//private Map<String, Customer> data; 
	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		//this.data = data;
	}

	public WalletRepoImpl() 
	{
		entityManager = JPAUtil.getEntityManager();
	}

	public boolean save(Customer customer) 
	{
	System.out.println(customer.getName());
	if(findOne(customer.getMobileNo())==null)
		
	{
		try 
		{	
			entityManager.persist(customer);
		} 
		catch (Exception e) 
		{
			throw new InvalidInputException(e.getMessage());
		}
		return true;
	}
	else 
	{
		throw new InvalidInputException("A user with this number already exists, enter a new number.");
	}
	}

	public Customer findOne(String mobileNo) 
	{	
		return entityManager.find(Customer.class, mobileNo);	
	}

	@Override
	public void updateBalance(Customer cust) {
		entityManager.merge(cust);
		
	}

	@Override
	public List<Transaction> getTransactions(String mobilenumber) throws InvalidInputException{
		String qStr = "SELECT trans FROM Transaction trans WHERE trans.mobileNumber=:m_no";
		TypedQuery<Transaction> query = entityManager.createQuery(qStr, Transaction.class);
		query.setParameter("m_no", mobilenumber);
		List<Transaction> bookList = query.getResultList();
		return bookList;
	}
	
	@Override
	public void setTransactions(Transaction transaction) 
	{
		try 
		{
			entityManager.persist(transaction);
		} 
		catch (Exception e) 
		{
			throw new InvalidInputException(e.getMessage());
		}
	}
		
	

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}
	
	
}
