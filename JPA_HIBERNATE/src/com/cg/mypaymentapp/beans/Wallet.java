package com.cg.mypaymentapp.beans;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Wallet implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="walletId")
int WalletId;

private BigDecimal balance;

public int getWalletId() {
	return WalletId;
}

public void setWalletId(int walletId) {
	WalletId = walletId;
}

public Wallet(BigDecimal amount) {
	this.balance=amount;
}

public Wallet() {
	// TODO Auto-generated constructor stub
}

public BigDecimal getBalance() {
	return balance;
}

public void setBalance(BigDecimal balance) {
	this.balance = balance;
}

@Override
	public String toString() {
	return ", balance="+balance;
}

}
