package com.infy.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public class CustomerDTO {
	
	private Integer customerId;
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
	
//	@Email(message="Please provide valid email id")
//	@NotNull(message="Email id can't be empty")
//	private String emailId;
//
//	@NotNull(message="Name can't be empty")
//	@Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message="Name should contain only alphabets and characters")
//    private String name;
//
//	@PastOrPresent(message="Date of birth should be past or present date")
//	private LocalDate dateOfBirth;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getEmailId() {
		return emailId;
	}	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + "]";
	}	
}
