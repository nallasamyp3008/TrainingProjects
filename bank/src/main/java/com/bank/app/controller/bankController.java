package com.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.constants.EnumResponse;
import com.bank.app.model.bankAccount;
import com.bank.app.model.bankAccountRequest;
import com.bank.app.model.bankAccountResponse;
import com.bank.app.model.updateAccountRequest;
import com.bank.app.service.bankService;

@RestController
@RequestMapping("/bank")
public class bankController {

	@Autowired
	private bankService bankservice;

	@GetMapping("/psq")
	public String firstRequest() {
		return "Welcome to PSQ Project";
	}

	@GetMapping("/all")
	public Iterable<bankAccount> getAllAccountDetails() {
		return bankservice.getAllAccounts();
	}

	@GetMapping("/view/{bid}")
	public ResponseEntity<bankAccount> getAccount(@PathVariable Integer bid) {

		bankAccount account = bankservice.getAccount(bid);
		if (account == null) {
			return new ResponseEntity<bankAccount>(account, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<bankAccount>(account, HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<bankAccountResponse> newAccount(@RequestBody bankAccountRequest req) {
		bankAccountResponse msg = new bankAccountResponse();

		ResponseEntity<bankAccountResponse> res = bankservice.validateUserInput(req);
		msg.setStatusCode(res.getBody().getStatusCode());
		msg.setMessage(res.getBody().getMessage());

		return new ResponseEntity<bankAccountResponse>(msg, res.getStatusCode());

	}

	@DeleteMapping("/delete/{bid}")
	public ResponseEntity<bankAccountResponse> deleteAccount(@PathVariable Integer bid) {
		bankAccountResponse msg = new bankAccountResponse();
		HttpStatus status;
		Boolean deleteAcc = bankservice.deleteAcc(bid);
		if (deleteAcc) {
			msg.setStatusCode(EnumResponse.DELETED_SUCCESS.getStatusCode());
			msg.setMessage(EnumResponse.DELETED_SUCCESS.getMessage());
			status = HttpStatus.OK;

		} else {
			msg.setStatusCode(EnumResponse.ID_NOT_FOUND.getStatusCode());
			msg.setMessage(EnumResponse.ID_NOT_FOUND.getMessage());
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<bankAccountResponse>(msg, status);

	}

	@PutMapping("/update")
	public ResponseEntity<bankAccountResponse> modifyAccount(@RequestBody updateAccountRequest account) {
		Boolean updateAccount = bankservice.updateAccount(account);
		bankAccountResponse msg=new bankAccountResponse();
		HttpStatus status;
		
		if (updateAccount)
		{msg.setStatusCode(EnumResponse.UPDATE_SUCCESS.getStatusCode());
		msg.setMessage(EnumResponse.UPDATE_SUCCESS.getMessage());
		status=HttpStatus.OK;
		}
		else {
			msg.setStatusCode(EnumResponse.ID_NOT_FOUND.getStatusCode());
			msg.setMessage(EnumResponse.ID_NOT_FOUND.getMessage());
			status=HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(msg,status);

	}

}
