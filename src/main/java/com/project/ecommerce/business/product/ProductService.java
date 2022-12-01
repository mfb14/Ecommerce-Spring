/**
 * ProductService.java
 */
package com.project.ecommerce.business.product;

import org.apache.catalina.valves.rewrite.RewriteCond;
import org.springframework.stereotype.Service;

import com.project.ecommerce.business.category.CategoryService;
import com.project.ecommerce.business.supplier.SupplierService;
import com.project.ecommerce.dto.product.ProductResponse;
import com.project.ecommerce.dto.product.ProductSaveRequest;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.repository.ProductRepository;

/**
 * @author Mustafa Furkan BİLEN
 * @since Dec 1, 2022 7:43:29 AM
 */
@Service
public class ProductService {

	ProductRepository productRepository;
	CategoryService categoryService;
	SupplierService supplierService;
	
	public ProductResponse save(ProductSaveRequest request) {
		
		Product productToSave = Product.builder()
									   .name(request.getName())
									   .description(request.getDescription())
									   .price(request.getPrice())
									   .unitStock(request.getUnitsStock())
									   .category
	
	}
	
}
