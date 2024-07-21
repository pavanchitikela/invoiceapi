

package com.demo.invoiceapi.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
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
	

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", customer_name=" + customer_name + ", amount=" + amount
				+ ", invoice_date=" + invoice_date + ", due_date=" + due_date + ", status=" + status + "]";
	}
	
}
