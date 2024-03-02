package org.dnyanyog.enums;

public enum CustomerResponseCode {

	SUCCESS_CUSTOMER_ADD("0000","Success", "Customer added successfully"),
	FAILED_CUSTOMER_ADD_EXISTS("0001","Error", "Email is already exist! Please enter valid emailID"),
	FAILED_UPDATE_CUSTOMER("0001","Fail", "Customer not present"), 
	FAILED_GET_CUSTOMER("0001","Fail", "Customer not found");

	private final String code;
	private final String status;
	private final String message;

	CustomerResponseCode(String code,String status, String message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
