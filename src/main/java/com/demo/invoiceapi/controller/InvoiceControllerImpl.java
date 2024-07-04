package com.demo.invoiceapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.invoiceapi.dto.InvoiceDTO;
import com.demo.invoiceapi.model.Invoice;
import com.demo.invoiceapi.service.InvoiceServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class InvoiceControllerImpl {

	@Autowired
	InvoiceServiceImpl invoiceServiceImpl;

	private static final Logger logger = LoggerFactory.getLogger(InvoiceControllerImpl.class);

	@GetMapping(path = "/allInvoices")
	public List<InvoiceDTO> getAllinvoices() {
		// logger.info("getAllinvoices() in invoiceControllerImpl is invoked!!!");
		return invoiceServiceImpl.getAllInvoices();
	}
	@GetMapping(path = "/invoices")
	public Page<InvoiceDTO> getinvoices(@RequestParam int page, @RequestParam int size) {
		// logger.info("getAllinvoices() in invoiceControllerImpl is invoked!!!");
		return invoiceServiceImpl.getInvoices(page, size);
	}

	@PostMapping(path = "/addInvoice")
	public ResponseEntity<Map<String, Object>> addInvoice(@RequestBody InvoiceDTO invoiceDto) {
		// logger.info("addInvoice() in invoiceControllerImpl is invoked!!!");
		logger.info(" Received object:" + invoiceDto);
		System.out.println(invoiceDto);
		String message = invoiceServiceImpl.addInvoice(invoiceDto);
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(path = "/deleteinvoice/{id}")
	public ResponseEntity<Map<String, Object>> deleteInvoice(@PathVariable long id) {
		String message = invoiceServiceImpl.deleteInvoice(id);
		logger.info(message);
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		return ResponseEntity.ok(response);

	}
	@PutMapping(path = "/updateInvoice")
	public Invoice updateInvoice(@RequestBody InvoiceDTO invoiceDto) {
		// logger.info("addInvoice() in invoiceControllerImpl is invoked!!!");
		logger.info(" Received object:" + invoiceDto);
		System.out.println(invoiceDto);
		return invoiceServiceImpl.updateInvoice(invoiceDto.getInvoiceNumber(), invoiceDto);
	}
}
