package com.project.ecommerce.dto;

import com.project.ecommerce.model.Gender;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class CustomerUpdateRequest {

	private Long id;
	private String phoneNumber;
	private Gender gender;
	private String city;
	private String addressDetails;
	private String postCode;
	
}
