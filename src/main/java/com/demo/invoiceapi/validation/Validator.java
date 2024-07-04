package com.demo.invoiceapi.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.invoiceapi.dto.InvoiceDTO;
import com.demo.invoiceapi.exceptionhandling.InvalidInvoiceNumberException;
import com.demo.invoiceapi.exceptionhandling.InvoiceAlreadyExistException;
import com.demo.invoiceapi.model.Invoice;
import com.demo.invoiceapi.repository.InvoiceRepo;

@Component
public class Validator {
	@Autowired
	InvoiceRepo invoiceRepo;
	
	public boolean validateInvoiceNumber(long invoiceNum) {
		boolean isValidInvoiceNum = false;
		String invoiceNumStr = String.valueOf(invoiceNum);
		if(!invoiceNumStr.startsWith("2")) {
			throw new InvalidInvoiceNumberException ("Invoice Number "+invoiceNum+" is invalid !!");
		}else {
			isValidInvoiceNum = true;
		}
		return isValidInvoiceNum;
	}
	
	public boolean isInvoiceExistsInDB(InvoiceDTO invoiceDto) {
		boolean isInvoiceExist = false;
		Optional<Invoice> invoiceOpt= invoiceRepo.findById(invoiceDto.getInvoiceNumber());
		if(invoiceOpt.isPresent()) {
			isInvoiceExist = true;
			throw new InvoiceAlreadyExistException("Invoice with ["+invoiceDto.getInvoiceNumber()+"] already exists !!!");
		}
		return isInvoiceExist;
	}

}
