package com.project.ecommerce.dto;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.project.ecommerce.model.Gender;

import lombok.Data;

@Data
public class CustomerSaveRequest {

	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String password;
	@NotBlank
	private String dateOfBirth;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String email;
	@NotNull
	private Gender gender;

	private String city;
	private String addressDetails;
	private String postCode;
	
}
