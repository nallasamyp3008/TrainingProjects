package com.bank.app.model;

public class bankAccountResponse {


	private int StatusCode;
	private String Message;

	

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		this.StatusCode = statusCode;
	}

	public void setMessage(String message) {
		this.Message = message;
	}

	public String getMessage() {
		return Message;
	}

}
