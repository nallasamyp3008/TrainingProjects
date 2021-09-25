package com.bank.app.constants;

public enum EnumResponse {

	ACCOUNT_CREATED(21000, "Account Creation Success"), ACCOUNT_CREATION_FAILED(21002, "Account Creation Failed"),
	CURRENCY_ERROR(21003, "Check Currency Name"), DUPLICATE_ACCOUNT(21004, "Account Number already exists"),
	UPDATE_SUCCESS(21005, "Record Updated Successfully"), ID_NOT_FOUND(21006, "Id Not Found"),
	ACCOUNT_NOT_FOUND(21007, "Account Number doesn't exists"), INVALID_CURRENCY(21008, "Check Currency Value"),
	DELETED_SUCCESS(21009, "Record has been deleted");
	

	private String Message;
	private int StatusCode;

	EnumResponse(int StatusCode, String Message) {
		this.setStatusCode(StatusCode);
		this.setMessage(Message);
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

}
