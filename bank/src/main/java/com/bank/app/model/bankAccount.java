package com.bank.app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name = "bid_gen", sequenceName = "bid_gen", initialValue = 1)
@Table(name = "BANK_ACCOUNT")
public class bankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bid_gen")
	@Column(name = "BID", unique = true , length=16)
	private Integer bid;

	@Column(name = "ACCOUNT_NUMBER", unique = true)
	private Long accountNumber;

	@Column(name = "ACCOUNT_HOLDER_NAME", length = 50)
	private String accountHolderName;

	@Column(name="DOB")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dateOfBirth;
	
	@Column(name = "CURRENCY", length = 3)
	private String currency;

	@CreationTimestamp
	@Column(name = "ACCOUNT_CREATION_DATE", updatable = false)
	private LocalDate accountCreationDate;

	@UpdateTimestamp
	@Column(name = "ACCOUNT_UPDATED_DATE", insertable = false)
	private LocalDate accountUpdationDate;

	@Column(name = "PAN")
	private String pan;

	@Column(name = "CREDIT_AMOUNT")
	private int creditAmount;

	@Column(name = "DEBIT_AMOUNT")
	private int debitAmount;

	@Column(name = "BALANCE")
	private int balance;

	@Column(name = "ACCOUNT_ACTIVE_STATUS")
	private String accountActiveStatus;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="bid" , referencedColumnName="bid") //unique=true,nullable=false,updatable=false)
	private balanceAccount balanceaccount;
	 

	
	

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public LocalDate getAccountUpdationDate() {
		return accountUpdationDate;
	}

	public void setAccountUpdationDate(LocalDate accountUpdationDate) {
		this.accountUpdationDate = accountUpdationDate;
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
	

	/*
	 * public balanceAccount getBalanceaccount() { return balanceaccount; }
	 * 
	 * public void setBalanceaccount(balanceAccount balanceaccount) {
	 * this.balanceaccount = balanceaccount; }
	 */

}
