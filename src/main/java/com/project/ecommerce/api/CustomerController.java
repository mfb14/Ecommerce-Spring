package com.project.ecommerce.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.business.customer.CustomerListService;
import com.project.ecommerce.business.customer.CustomerSaveService;
import com.project.ecommerce.business.customer.CustomerUpdateService;
import com.project.ecommerce.dto.customer.CustomerListResponse;
import com.project.ecommerce.dto.customer.CustomerSaveRequest;
import com.project.ecommerce.dto.customer.CustomerSaveResponse;
import com.project.ecommerce.dto.customer.CustomerUpdateRequest;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	CustomerSaveService customerSaveService;
	CustomerUpdateService customerUpdateService;
	CustomerListService customerListService;
	
	public CustomerController(CustomerSaveService customerSaveService, CustomerUpdateService customerUpdateService,
							  CustomerListService customerListService) {
		
		this.customerSaveService = customerSaveService;
		this.customerUpdateService = customerUpdateService;
		this.customerListService = customerListService;
	}
	
	@PostMapping(name = "/save")
	public ResponseEntity<CustomerSaveResponse> saveCustomer(@Valid @RequestBody CustomerSaveRequest customerToSave){
		return new ResponseEntity<>(customerSaveService.saveCustomer(customerToSave),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerUpdateRequest> updateCustomer(@Valid @RequestBody CustomerUpdateRequest request,@PathVariable Long id){
		return ResponseEntity.ok(customerUpdateService.updateCustomer(request,id));
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId){
		customerSaveService.deleteCustomer(customerId);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/list/getAll")
	public ResponseEntity<List<CustomerListResponse>> listAllCustomer(){
		
		return ResponseEntity.ok(customerListService.findAll());
	}
	
	@GetMapping("/list/name")
	public ResponseEntity<List<CustomerListResponse>> listByNameContaining(@RequestParam String firstName){
		return new ResponseEntity<List<CustomerListResponse>>(customerListService.findByNameContaining(firstName),HttpStatus.OK);
	}
	
}
