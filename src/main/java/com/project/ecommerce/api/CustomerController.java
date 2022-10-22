package com.project.ecommerce.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.business.CustomerSaveService;
import com.project.ecommerce.business.CustomerUpdateService;
import com.project.ecommerce.dto.CustomerSaveRequest;
import com.project.ecommerce.dto.CustomerSaveResponse;
import com.project.ecommerce.dto.CustomerUpdateRequest;

import lombok.RequiredArgsConstructor;






@RestController
@RequestMapping("api/v1/customer")
@Validated
@RequiredArgsConstructor
public class CustomerController {

	CustomerSaveService customerSaveService;
	CustomerUpdateService customerUpdateService;
	
	
	
	
	@PostMapping(name = "/save")
	public ResponseEntity<CustomerSaveResponse> saveCustomer(@Valid @RequestBody CustomerSaveRequest customerToSave){
		
		
		return new ResponseEntity<>(customerSaveService.saveCustomer(customerToSave),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody CustomerUpdateRequest request){
		
		return ResponseEntity.ok(null);
	}
	

	
}
