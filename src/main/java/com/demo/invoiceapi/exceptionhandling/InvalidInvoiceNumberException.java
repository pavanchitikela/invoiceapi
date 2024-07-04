package com.demo.invoiceapi.exceptionhandling;

public class InvalidInvoiceNumberException extends RuntimeException {

	public InvalidInvoiceNumberException(String message) {
		
		super(message);
	}

}
