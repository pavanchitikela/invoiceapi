
package com.demo.invoiceapi.dto;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "invoiceNumber", "customerName", "amountDue", "invoiceDate", "dueDate", "status" })

public class InvoiceDTO {

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("invoiceNumber")
	private long invoiceNumber;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("customerName")
	private String customerName;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("amountDue")
	private double amountDue;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("invoiceDate")
	private LocalDate invoiceDate;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("dueDate")
	private LocalDate dueDate;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("status")
	private String status;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("invoiceNumber")
	public long getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("invoiceNumber")
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("customerName")
	public String getCustomerName() {
		return customerName;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("customerName")
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("amountDue")
	public double getAmountDue() {
		return amountDue;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("amountDue")
	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("invoiceDate")
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("invoiceDate")
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("dueDate")
	public LocalDate getDueDate() {
		return dueDate;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("dueDate")
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

}