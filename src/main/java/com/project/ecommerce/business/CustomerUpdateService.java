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
public class CustomerUpdateService {

	CustomerRepository customerRepository;
	AddressRepository addressRepository;
	
	public CustomerUpdateService(CustomerRepository customerRepository, AddressRepository addressRepository) {
	
		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
	}
	
	public CustomerUpdateRequest updateCustomer(CustomerUpdateRequest request,Long id) {
		
		//After the GlobalException created this method will refactor.
		Customer customer = customerRepository.findById(id).get();
		
		if(Objects.isNull(customer))
			throw new CustomerIsNotExistException(("Customer is not Exist!"));
		
		customer.setPhoneNumber(getOrDefault(request.getPhoneNumber(), customer.getPhoneNumber()));
		customer.setGender(getOrDefault(request.getGender(), customer.getGender()));
		Long adId = customer.getAddress().getId();
		Address ad = addressRepository.findById(adId).get();
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
