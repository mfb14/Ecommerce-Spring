/**
 * ProductController.java
 */
package com.project.ecommerce.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.business.product.ProductService;
import com.project.ecommerce.dto.product.ProductResponse;
import com.project.ecommerce.dto.product.ProductSaveRequest;

/**
 * @author Mustafa Furkan BİLEN
 * @since Dec 1, 2022 8:32:20 AM
 */
@RestController
@RequestMapping("/products")
public class ProductController {
	
	ProductService productService;

	private ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping("save")
	public ResponseEntity<ProductResponse> save(@RequestBody ProductSaveRequest request){
		
		return new ResponseEntity<ProductResponse>(productService.save(request),HttpStatus.CREATED);
	}
}
