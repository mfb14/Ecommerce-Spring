/**
 * SupplierController.java
 */
package com.project.ecommerce.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.business.supplier.SupplierService;
import com.project.ecommerce.dto.supplier.SupplierResponse;
import com.project.ecommerce.dto.supplier.SupplierSaveRequest;
import com.project.ecommerce.dto.supplier.SupplierUpdateRequest;

import lombok.AllArgsConstructor;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 21, 2022 4:41:42 PM
 */
@RestController
@RequestMapping("/suppliers")
@AllArgsConstructor
public class SupplierController {

	private SupplierService supplierService;
	
	@PostMapping(name ="/save")
	public ResponseEntity<SupplierResponse> save(@RequestBody SupplierSaveRequest request){
		
		return new ResponseEntity<>(supplierService.save(request),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<SupplierResponse> update(@PathVariable Long id, @RequestBody SupplierUpdateRequest updateRequest){
		
		return new ResponseEntity<SupplierResponse>(supplierService.update(id,updateRequest),HttpStatus.OK);
	}
	
	
	
}
