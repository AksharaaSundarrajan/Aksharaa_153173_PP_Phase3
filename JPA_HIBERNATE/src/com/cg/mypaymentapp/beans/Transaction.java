package com.cg.mypaymentapp.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Transaction")
public class Transaction implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="MOBILE_NUMBER")
	String mobileNumber;
	@Column(name="TRANSACTION_DATE")
	String dateOfTransaction;
	@Column(name="TRANSACTION_TYPE")
	String transactionType;
	@Column(name="TRANSACTION_STATUS")
	String transactionStatus;
	@Column(name="AMOUNT")
	BigDecimal amount;
	
	
	public Transaction() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Transaction(String mobileNumber, String dateOfTransaction, String transactionType, String transactionStatus,
			BigDecimal amount) {
		super();
		this.mobileNumber = mobileNumber;
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.amount = amount;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getDateOfTransaction() {
		return dateOfTransaction;
	}


	public void setDateOfTransaction(String dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
	@Override
	public String toString() {
		return "Transaction [mobileNumber=" + mobileNumber + ", dateOfTransaction=" + dateOfTransaction
				+ ", transactionType=" + transactionType + ", transactionStatus=" + transactionStatus + ", amount="
				+ amount + "]";
	}
	
	
	
}
