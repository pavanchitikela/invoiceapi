package com.demo.invoiceapi.exceptionhandling;

public class InvoiceAlreadyExistException extends RuntimeException {
public InvoiceAlreadyExistException(String message) {
		
		super(message);
	}
}
