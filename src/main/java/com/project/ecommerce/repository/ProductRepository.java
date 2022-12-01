/**
 * ProductRepository.java
 */
package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Product;

/**
 * @author Mustafa Furkan BİLEN
 * @since Dec 1, 2022 7:44:45 AM
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,JpaSpecificationExecutor<Product> {

}
