package com.project.ecommerce.business.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.ecommerce.dto.customer.CustomerListResponse;
import com.project.ecommerce.repository.CustomerRepository;




@Service
public class CustomerListService {

	CustomerRepository customerRepository;

	public CustomerListService(CustomerRepository customerRepository) {

		this.customerRepository = customerRepository;
	}

	public List<CustomerListResponse> findAll() {
		return customerRepository.findAll().stream()
									.map(CustomerListResponse::from)
									.collect(Collectors.toList());
		
	}

	public List<CustomerListResponse> findByNameContaining(String firstName) {
		return customerRepository.findByFirstNameContainingIgnoreCase(firstName).stream()
															.map(CustomerListResponse::from)
															.collect(Collectors.toList());
		
	}
	
	
	
}
