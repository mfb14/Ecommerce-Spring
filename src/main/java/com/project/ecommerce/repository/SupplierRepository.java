/**
 * SupplierRepository.java
 */
package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.Supplier;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 21, 2022 4:43:03 PM
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	
}
