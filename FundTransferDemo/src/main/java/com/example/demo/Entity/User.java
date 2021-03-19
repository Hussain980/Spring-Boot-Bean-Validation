package com.example.demo.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@NotEmpty(message = "userId required")
	@Email
	private String userId;
	
	@NotEmpty(message = "firstName required")
	@Size(min=4, max = 20,message = "enter at least 4 characters and not more than 20 characters")
	private String firstName;
	
	@NotEmpty(message = "lastName required")
	@Size(min=3, max = 20,message = "enter at least 3 characters and not more than 20 characters")
	private String lastName;
	
	@NotEmpty(message = "Password is required")
	@Size(min=5, max = 10,message = "enter at least 5 characters and not more than 10 characters")
	private String password;
	
	@NotNull(message = "DOB is required")
	@JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "dd-mm-yyyy")
	private Date dob;
	
	@NotNull(message = "Account Number required")
	@JsonFormat(shape= JsonFormat.Shape.STRING)
	private Long accNumber;
	
	@NotNull(message = "Account balance required")
	@JsonFormat(shape= JsonFormat.Shape.STRING)
	private Double accBalance;
	
	@NotEmpty(message = "Aadhar Number required")
	@JsonFormat(shape= JsonFormat.Shape.STRING)
	private String aadharId;

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public Long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Long accNumber) {
		this.accNumber = accNumber;
	}

	public Double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(Double accBalance) {
		this.accBalance = accBalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}
