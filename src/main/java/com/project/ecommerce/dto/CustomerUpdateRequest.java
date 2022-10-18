package com.project.ecommerce.dto;

import com.project.ecommerce.model.Gender;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CustomerUpdateRequest {

	private Long customerId;
	private String password;
	private String phoneNumber;
	private String email;
	private Gender gender;
	private String city;
	private String addressDetails;
	private String postCode;
	
}
