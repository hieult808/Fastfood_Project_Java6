package com.poly.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "InvoiceItems")
public class InvoiceItem implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;

	@Id
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "unit_price")
	private double unitPrice;

	// Getters and Setters
}
