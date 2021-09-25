package com.bank.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.model.balanceAccount;

public interface balanceRepository extends JpaRepository<balanceAccount,Serializable>{

	
}
