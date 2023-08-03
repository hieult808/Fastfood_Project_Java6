package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
