/**
 * SupplierSaveRequest.java
 */
package com.project.ecommerce.dto.supplier;



import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 21, 2022 4:46:41 PM
 */
@Data
public class SupplierSaveRequest {

	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String phoneNumber;
	
}
