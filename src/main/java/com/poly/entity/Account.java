package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;

	@Column(name = "username")
	private String username;

	@Column(name = "pass_work")
	private String password;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private int phoneNumber;

	@Column(name = "image")
	private String image;

	@Column(name = "address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "roles")
	private Role role;

	@Column(name = "active")
	private boolean active;

	// Getters and Setters
}
