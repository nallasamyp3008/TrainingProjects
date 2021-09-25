package com.bank.app.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class bankAccountRequest {

	
	private Long accountNumber;

	private String accountHolderName;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dateOfBirth;

	private String currency;

	private String pan;

	private int creditAmount;

	private int debitAmount;

	private int balance;

	private String accountActiveStatus;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public int getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}

	public int getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(int debitAmount) {
		this.debitAmount = debitAmount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccountActiveStatus() {
		return accountActiveStatus;
	}

	public void setAccountActiveStatus(String accountActiveStatus) {
		this.accountActiveStatus = accountActiveStatus;
	}
	
	

}
