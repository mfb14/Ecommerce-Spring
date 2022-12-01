/**
 * SupplierService.java
 */
package com.project.ecommerce.business.supplier;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.dto.supplier.SupplierResponse;
import com.project.ecommerce.dto.supplier.SupplierSaveRequest;
import com.project.ecommerce.dto.supplier.SupplierUpdateRequest;
import com.project.ecommerce.model.Supplier;
import com.project.ecommerce.repository.SupplierRepository;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 21, 2022 4:45:18 PM
 */
@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;


	public SupplierResponse save(SupplierSaveRequest request) {
		Supplier suplierToSave =  Supplier.builder()
										     .name(request.getName())
										     .password(request.getPassword())
										     .email(request.getEmail())
										     .phoneNumber(request.getPhoneNumber())
										     .build();
		
		Supplier fromDb = supplierRepository.save(suplierToSave);
		
		return SupplierResponse.builder()
							   .id(fromDb.getId())
							   .name(fromDb.getName())
							   .email(fromDb.getEmail())
							   .phoneNumber(fromDb.getPhoneNumber())
							   .build();
		
	}
	
	public SupplierResponse update(Long id,SupplierUpdateRequest updateRequest) {
		Supplier fromDb = supplierRepository.findById(id).orElseThrow(()->  new NoSuchElementException("This Supplier Is Not Found!"));
		
		 	
		fromDb.setName(getOrDefault(updateRequest.getName(),fromDb.getName()));
		fromDb.setPassword(getOrDefault(updateRequest.getPassword(), fromDb.getPassword()));
		fromDb.setEmail(getOrDefault(updateRequest.getEmail(), fromDb.getEmail()));		
		fromDb.setPhoneNumber(getOrDefault(updateRequest.getPhoneNumber(), fromDb.getPhoneNumber()));
								  
		final Supplier responseSupplier = supplierRepository.save(fromDb);
		
		return SupplierResponse.builder()
							   .id(responseSupplier.getId())
							   .name(responseSupplier.getName())
							   .email(responseSupplier.getEmail())
							   .phoneNumber(responseSupplier.getPhoneNumber())
							   .build();
		
		
	}
	/**
	 * If the data did not change, get default data
	 * @param data The data that is changed
	 * @param defaultValue The data what is stored in Db
	 * */
	private static <T> T getOrDefault(T data, T defaultValue) {
		return data == null ?defaultValue:data;
	}
	
	public SupplierResponse findById(Long id) {
		
		Supplier supplier = supplierRepository.findById(id).get();
		
		return SupplierResponse.builder()
							   .name(supplier.getName())
							   .email(supplier.getEmail())
							   .phoneNumber(supplier.getPhoneNumber())
							   .build();
	}
	
}
