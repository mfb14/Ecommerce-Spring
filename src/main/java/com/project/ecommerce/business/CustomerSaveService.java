package com.project.ecommerce.business;




import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ecommerce.business.CustomerSaveService;
import com.project.ecommerce.dto.CustomerSaveRequest;
import com.project.ecommerce.dto.CustomerSaveResponse;
import com.project.ecommerce.model.Address;
import com.project.ecommerce.model.Customer;
import com.project.ecommerce.repository.AddressRepository;
import com.project.ecommerce.repository.CustomerRepository;



@Service
public class CustomerSaveService{

	private CustomerRepository customerRepository;
	private AddressRepository addressRepository;
	

	public CustomerSaveService(CustomerRepository customerRepository, AddressRepository addressRepository) {

		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
	}
	
	
	
	@Transactional
	public CustomerSaveResponse saveCustomer(CustomerSaveRequest customerToSave) {
		
		
		
		Address ad = Address.builder()
							.city(customerToSave.getCity())
							.addressDetails(customerToSave.getAddressDetails())
							.postCode(customerToSave.getPostCode())
							.build();
		
		ad.setCity(customerToSave.getCity());
		ad.setAddressDetails(customerToSave.getAddressDetails());
		ad.setPostCode(customerToSave.getPostCode());
		
		 
		Address fromDbAddress = this.addressRepository.save(ad);	
		Customer newCustomer = Customer.builder()
											 .dateOfBirth(customerToSave.getDateOfBirth())
											 .firstName(customerToSave.getFirstName())
											 .lastName(customerToSave.getLastName())
											 .gender(customerToSave.getGender())
											 .email(customerToSave.getEmail())
											 .password(customerToSave.getPassword())
											 .phoneNumber(customerToSave.getPhoneNumber())
											 .address(ad)
											 .build();

		 Customer fromDb = this.customerRepository.save(newCustomer);

		  return CustomerSaveResponse.builder()
								   .firstName(fromDb.getFirstName())
								   .lastName(fromDb.getLastName())
								   .password(fromDb.getPassword())
								   .dateOfBirth(fromDb.getDateOfBirth())
								   .phoneNumber(fromDb.getPhoneNumber())
								   .email(fromDb.getEmail())
								   .gender(fromDb.getGender())
								   .city(fromDbAddress.getCity())
								   .addressDetails(fromDbAddress.getAddressDetails())
								   .postCode(fromDbAddress.getPostCode())
								   .build();
	
		
	}



	public void deleteCustomer(Long customerId) {
		customerRepository.deleteById(customerId);
		
	}

	


	
}
