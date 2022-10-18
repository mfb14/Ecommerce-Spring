package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.project.ecommerce.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>,JpaSpecificationExecutor<Customer>{

	
}
