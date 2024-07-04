package com.demo.invoiceapi.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {
	
	 	@ExceptionHandler(InvalidInvoiceNumberException.class)
	    public ResponseEntity<String> handleInvalidInvoiceException(InvalidInvoiceNumberException ex){
	 		System.out.println(ex.getMessage());
	 		ResponseEntity<String> responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	        return responseEntity;
	    }
	 	
		@ExceptionHandler(InvoiceAlreadyExistException.class)
	    public ResponseEntity<String> handleResourceNotFoundException(InvoiceAlreadyExistException ex){
	 		System.out.println(ex.getMessage());
	 		ResponseEntity<String> responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	        return responseEntity;
	    }
}
