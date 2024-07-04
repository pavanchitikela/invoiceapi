package com.demo.invoiceapi.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "invoice")
public class Invoice {
	
	@Id
	@Column(name = "invoice_id")
	private long invoice_id;
	@Column(name = "customer_name")
	private String customer_name;
	@Column(name = "amount")
	private double amount;
	@Column(name = "invoice_date")
	private LocalDate invoice_date;
	@Column(name = "due_date")
	private LocalDate due_date;
	@Column(name = "status")
	private String status;
	
	public long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(LocalDate invoice_date) {
		this.invoice_date = invoice_date;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", customer_name=" + customer_name + ", amount=" + amount
				+ ", invoice_date=" + invoice_date + ", due_date=" + due_date + ", status=" + status + "]";
	}
	
}
