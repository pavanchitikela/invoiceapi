package com.demo.invoiceapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.invoiceapi.dto.InvoiceDTO;
import com.demo.invoiceapi.mapping.InvoiceDTOMapper;
import com.demo.invoiceapi.model.Invoice;
import com.demo.invoiceapi.repository.InvoiceRepo;
import com.demo.invoiceapi.validation.Validator;

@Service
public class InvoiceServiceImpl {

	@Autowired
	Validator validator;

	@Autowired
	InvoiceRepo invoiceRepo;

	@Autowired
	InvoiceDTOMapper invoiceDTOMapper;

	public List<InvoiceDTO> getAllInvoices() {
		List<Invoice> invoiceList = invoiceRepo.findAll();
		List<InvoiceDTO> invoiceDTOList = new ArrayList<>();
		for(Invoice invoice: invoiceList) {
			InvoiceDTO invoieDto = new InvoiceDTO();
			invoieDto.setInvoiceNumber(invoice.getInvoice_id());
			invoieDto.setAmountDue(invoice.getAmount());
			invoieDto.setCustomerName(invoice.getCustomer_name());
			invoieDto.setDueDate(invoice.getDue_date());
			invoieDto.setInvoiceDate(invoice.getInvoice_date());
			invoieDto.setStatus(invoice.getStatus());
			invoiceDTOList.add(invoieDto);
		}
		return invoiceDTOList;
	}
	public Page<InvoiceDTO> getInvoices(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Invoice> invoicePage = invoiceRepo.findAll(pageable); 
        Page<InvoiceDTO> invoiceDTOPage=invoicePage.map(invoiceDTOMapper::mapInvoicetoInvoiceDTO);
        return invoiceDTOPage;
    }

	public String addInvoice(InvoiceDTO invoiceDto) {
		boolean isInvoiceNumValid = validator.validateInvoiceNumber(invoiceDto.getInvoiceNumber());
		if((isInvoiceNumValid) && !validator.isInvoiceExistsInDB(invoiceDto)) {
			Invoice savedInvoice = invoiceRepo.save(invoiceDTOMapper.mapInvoiceDTOtoInvoice(invoiceDto));
			return (savedInvoice != null) ? "Successfully inserted in DataBase" : "Failed to insert in DataBase";
		}
		return "Insertion Failed";
	}

	public String deleteInvoice(long id) {
		invoiceRepo.deleteById(id);
		return "Invoice deleted successfully";
	}

	public Invoice updateInvoice(long id, InvoiceDTO newInvoiceDTO) {
		Optional<Invoice> invoiceOpt = invoiceRepo.findById(newInvoiceDTO.getInvoiceNumber());
		if(invoiceOpt.isPresent()) {
			invoiceOpt.get().setCustomer_name(newInvoiceDTO.getCustomerName());
			invoiceOpt.get().setAmount(newInvoiceDTO.getAmountDue());
			invoiceOpt.get().setDue_date(newInvoiceDTO.getDueDate());
			invoiceOpt.get().setInvoice_date(newInvoiceDTO.getInvoiceDate());
			invoiceOpt.get().setStatus(newInvoiceDTO.getStatus());
			return invoiceRepo.save(invoiceOpt.get());
		}
		return null;
	}

}
