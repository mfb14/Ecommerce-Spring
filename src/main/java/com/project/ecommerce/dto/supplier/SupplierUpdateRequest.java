/**
 * SupplierUpdateRequest.java
 */
package com.project.ecommerce.dto.supplier;

import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 21, 2022 5:09:44 PM
 */
@Data
public class SupplierUpdateRequest {

	private String name;
	private String password;
	private String email;
	private String phoneNumber;
	
	
}
