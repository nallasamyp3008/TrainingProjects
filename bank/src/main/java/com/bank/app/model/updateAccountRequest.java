package com.bank.app.model;

public class updateAccountRequest {
	
	private Integer bid;

	private Long accountNumber;

	private String accountHolderName;

	private String currency;
	
	private String pan;

	private int creditAmount;

	private int debitAmount;

	
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

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
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



	@Override
	public String toString() {
		return "updateAccountRequest [bid=" + bid + ", accountNumber=" + accountNumber + ", accountHolderName="
				+ accountHolderName + ", currency=" + currency + ", pan=" + pan + ", creditAmount=" + creditAmount
				+ ", debitAmount=" + debitAmount +  "]";
	}

	
}