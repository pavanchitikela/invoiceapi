package com.demo.invoiceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.invoiceapi.model.Invoice;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice, Long> {

}
