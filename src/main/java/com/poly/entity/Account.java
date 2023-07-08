package com.poly.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;

	@Column(name = "username")
	private String username;

	@NotBlank(message = "{NotBlank.account.password}")
	@Column(name = "pass_work")
	private String password;

	@Column(name = "full_name")
	private String fullName;
	
	@NotBlank(message = "{NotBlank.account.email}")
	@Email(message = "{Email.account.email}")
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
