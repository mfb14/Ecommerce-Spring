package com.project.ecommerce.dto.customer;



import com.project.ecommerce.model.Gender;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CustomerSaveResponse {

	
	private String firstName;
	private String lastName;
	private String password;
	private String dateOfBirth;
	private String phoneNumber;
	private String email;
	private Gender gender;
	private String city;
	private String addressDetails;
	private String postCode;
	
}
