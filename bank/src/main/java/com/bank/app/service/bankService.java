package com.bank.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.app.constants.EnumCurrency;
import com.bank.app.constants.EnumResponse;
import com.bank.app.model.bankAccount;
import com.bank.app.model.bankAccountRequest;
import com.bank.app.model.bankAccountResponse;
import com.bank.app.model.updateAccountRequest;
import com.bank.app.repository.bankRepository;

@Service
public class bankService {

	@Autowired
	private bankRepository bankRepo;

	public Boolean createAccount(bankAccount bankaccount) {
		bankAccount newAccount;
		if (bankaccount.getCurrency().equals("USD") || bankaccount.getCurrency().equals("EUR")) {
			bankaccount.setCurrency(EnumCurrency.ITL.name());
			newAccount = bankRepo.save(bankaccount);

			if (newAccount != null)
				return true;

		} else if (bankaccount.getCurrency().equals("INR")) {

			bankaccount.setCurrency(EnumCurrency.EUR.name());
			newAccount = bankRepo.save(bankaccount);

			if (newAccount != null)
				return true;

		}
		return false;
	}

	public Iterable<bankAccount> getAllAccounts() {
		return bankRepo.findAll();
	}

	public bankAccount getAccount(Integer bid) {
		bankAccount getAcc = bankRepo.getrecord(bid);
		return getAcc;
	}

	public Boolean deleteAcc(Integer bid) {
		if (getAccount(bid) == null)
			return false;

		bankRepo.deleteById(bid);
		return true;
	}

	public Boolean updateAccount(updateAccountRequest req) {
		bankAccount getAcc = bankRepo.getrecord(req.getBid());

		if (getAcc != null && getAcc.getAccountNumber().equals(req.getAccountNumber())) {

			BeanUtils.copyProperties(req, getAcc);
			getAcc.setBalance(getAcc.getBalance() + (req.getCreditAmount() - req.getDebitAmount()));

			bankRepo.save(getAcc);
			return true;

		}

		return false;

	}

	private Boolean validateAccountNumber(Long accNo) {

		bankAccount findAccount = bankRepo.findByAccountNumber(accNo);
		if (findAccount != null)
			return true;

		return false;
	}

	private Boolean validateCurrency(String currency) {

		// EnumCurrency.values().equals(currency);

		for (EnumCurrency type : EnumCurrency.values()) {
			if (type.name().equals(currency)) {
				return true;
			}
		}

		return false;

	}

	public ResponseEntity<bankAccountResponse> validateUserInput(bankAccountRequest req) {
		bankAccountResponse msg = new bankAccountResponse();
		HttpStatus status;
		Boolean validateAccountNumber = validateAccountNumber(req.getAccountNumber());
		if (validateAccountNumber) {
			msg.setStatusCode(EnumResponse.DUPLICATE_ACCOUNT.getStatusCode());
			msg.setMessage(EnumResponse.DUPLICATE_ACCOUNT.getMessage());
			status = HttpStatus.BAD_REQUEST;
		} else if (!validateCurrency(req.getCurrency())) {
			msg.setStatusCode(EnumResponse.CURRENCY_ERROR.getStatusCode());
			msg.setMessage(EnumResponse.CURRENCY_ERROR.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}

		else {
			bankAccount bankaccount = new bankAccount();

			BeanUtils.copyProperties(req, bankaccount);

			Boolean accountCreation = createAccount(bankaccount);

			if (accountCreation) {
				msg.setStatusCode(EnumResponse.ACCOUNT_CREATED.getStatusCode());
				msg.setMessage(EnumResponse.ACCOUNT_CREATED.getMessage());
				status = HttpStatus.OK;
			} else {
				msg.setStatusCode(EnumResponse.ACCOUNT_CREATION_FAILED.getStatusCode());
				msg.setMessage(EnumResponse.ACCOUNT_CREATION_FAILED.getMessage());
				status = HttpStatus.BAD_REQUEST;
			}
		}
		return new ResponseEntity<bankAccountResponse>(msg, status);
	}

}
