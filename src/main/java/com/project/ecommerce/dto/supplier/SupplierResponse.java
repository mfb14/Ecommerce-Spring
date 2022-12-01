/**
 * SupplierResponse.java
 */
package com.project.ecommerce.dto.supplier;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.ecommerce.model.Supplier;

import lombok.Builder;
import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 21, 2022 4:54:18 PM
 */
@Data
@Builder
public class SupplierResponse {

	@JsonIgnore
	private Long id;
	private String name;
	private String email;	
	private String phoneNumber;
	
	public static Supplier from(SupplierResponse supplierResponse) {
		
		return Supplier.builder()
				       .name(supplierResponse.getName())
				       .email(supplierResponse.getEmail())
				       .phoneNumber(supplierResponse.getPhoneNumber())
				       .build();
				
	}
}
