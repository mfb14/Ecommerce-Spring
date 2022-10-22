package com.project.ecommerce.business;

import java.util.Objects;


import org.springframework.stereotype.Service;

import com.project.ecommerce.dto.CustomerUpdateRequest;
import com.project.ecommerce.exception.CustomerIsNotExistException;
import com.project.ecommerce.model.Address;
import com.project.ecommerce.model.Customer;
import com.project.ecommerce.repository.AddressRepository;
import com.project.ecommerce.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerUpdateService {

	CustomerRepository customerRepository;
	AddressRepository addressRepository;
	
	public CustomerUpdateRequest updateCustomer(CustomerUpdateRequest request) {
		
		//After the GlobalException created this method will refactor.
		Customer customer = customerRepository.findById(request.getId()).get();
		
		if(Objects.isNull(customer))
			throw new CustomerIsNotExistException(("Customer is not Exist!"));
		customer.setPhoneNumber(getOrDefault(request.getPhoneNumber(), customer.getPhoneNumber()));
		customer.setGender(getOrDefault(request.getGender(), customer.getGender()));
		
		Address ad = addressRepository.findById(request.getAddressId()).get();
		ad.setCity(getOrDefault(request.getCity(), ad.getCity()));
		ad.setAddressDetails(getOrDefault(request.getAddressDetails(),ad.getAddressDetails()));
		ad.setPostCode(getOrDefault(request.getPostCode(), ad.getPostCode()));
		
		customer.setAddress(ad);
		
		final Customer responseCustomer = customerRepository.save(customer);
		
		return CustomerUpdateRequest.builder()
									.phoneNumber(responseCustomer.getPhoneNumber())
									.gender(responseCustomer.getGender())
									.city(responseCustomer.getAddress().getCity())
									.addressDetails(responseCustomer.getAddress().getAddressDetails())
									.postCode(responseCustomer.getAddress().getPostCode())
									.build();
	}
	
	private static <T> T getOrDefault(T data, T defaultValue) {
		return data == null ?defaultValue:data;
	}
	
}
