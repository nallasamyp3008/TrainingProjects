package com.bank.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="id",sequenceName="id",initialValue=15001)
@Table(name="BALANCE_ACCOUNT")
public class balanceAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="id")
	@Column(name="ID" , unique=true,nullable=false)
	private Integer id;
	
	@Column(name="BID" ,length=16)
	private Integer bid;
	
	@Column(name="BALANCE_AMOUNT")
	private Integer balanceAmount;


	public balanceAccount(Integer bid, Integer balanceAmount) {
		this.bid = bid;
		this.balanceAmount = balanceAmount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Integer balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	
	

}
