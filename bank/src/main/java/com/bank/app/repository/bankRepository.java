package com.bank.app.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.app.model.bankAccount;

public interface bankRepository extends JpaRepository<bankAccount,Serializable>{
	
	
	@Query("select s from bankAccount s WHERE BID= :bid")
	public bankAccount getrecord(Integer bid);
	
	
	@Query("select a from bankAccount a where ACCOUNT_NUMBER = :AccNo")
	public bankAccount findByAccountNumber(Long AccNo);
	
	//@Query("update bankAccount a set PAN= :pan where  BID= : pan")
	//void updatePAN (Integer bid,String pan);


	
		
	
	
	

}
