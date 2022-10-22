package com.project.ecommerce.dto;

import com.project.ecommerce.model.Gender;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CustomerUpdateRequest {

	private Long id;
	private String phoneNumber;
	private Gender gender;
	private Long addressId;
	private String city;
	private String addressDetails;
	private String postCode;
	
}
