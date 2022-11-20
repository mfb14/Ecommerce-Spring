package com.project.ecommerce.dto.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.ecommerce.model.Customer;
import com.project.ecommerce.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CustomerListResponse {
	
	private Long id;
	private String firstName;
	private String lastName;
	@JsonIgnore
	private String password;
	private String dateOfBirth;
	private String phoneNumber;
	private String email;
	private Gender gender;
	private String city;
	private String addressDetails;
	private String postCode;
	
	public static CustomerListResponse from(Customer customer) {
		
		return CustomerListResponse.builder()
								   .id(customer.getId())
								   .firstName(customer.getFirstName())
								   .lastName(customer.getLastName())
								   .password(customer.getPassword())
								   .dateOfBirth(customer.getDateOfBirth())
								   .phoneNumber(customer.getPhoneNumber())
								   .email(customer.getEmail())
								   .gender(customer.getGender())
								   .city(customer.getAddress().getCity())
								   .addressDetails(customer.getAddress().getAddressDetails())
								   .postCode(customer.getAddress().getPostCode())
								   .build();
	}
	
	
}
