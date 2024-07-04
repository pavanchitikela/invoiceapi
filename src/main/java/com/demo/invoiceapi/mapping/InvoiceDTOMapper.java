package com.demo.invoiceapi.mapping;

import org.springframework.stereotype.Component;

import com.demo.invoiceapi.dto.InvoiceDTO;
import com.demo.invoiceapi.model.Invoice;

@Component
public class InvoiceDTOMapper {

	public Invoice mapInvoiceDTOtoInvoice(InvoiceDTO invoiceDTO) {
		Invoice invoice = new Invoice();
		invoice.setInvoice_id(invoiceDTO.getInvoiceNumber());
		invoice.setCustomer_name(invoiceDTO.getCustomerName());
		invoice.setInvoice_date(invoiceDTO.getInvoiceDate());
		invoice.setAmount(invoiceDTO.getAmountDue());
		invoice.setDue_date(invoiceDTO.getDueDate());
		invoice.setStatus(invoiceDTO.getStatus());
		return invoice;
	}

	public InvoiceDTO mapInvoicetoInvoiceDTO(Invoice invoice) {
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setInvoiceNumber(invoice.getInvoice_id());
		invoiceDTO.setAmountDue(invoice.getAmount());
		invoiceDTO.setCustomerName(invoice.getCustomer_name());
		invoiceDTO.setDueDate(invoice.getDue_date());
		invoiceDTO.setInvoiceDate(invoice.getInvoice_date());
		invoiceDTO.setStatus(invoice.getStatus());
		return invoiceDTO;
	}

}
