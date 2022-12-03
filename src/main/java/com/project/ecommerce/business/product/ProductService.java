/**
 * ProductService.java
 */
package com.project.ecommerce.business.product;

import org.springframework.stereotype.Service;

import com.project.ecommerce.business.category.CategoryService;
import com.project.ecommerce.business.supplier.SupplierService;
import com.project.ecommerce.dto.product.ProductResponse;
import com.project.ecommerce.dto.product.ProductSaveRequest;
import com.project.ecommerce.dto.supplier.SupplierResponse;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.model.Supplier;
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
	
	private ProductService(ProductRepository productRepository, CategoryService categoryService,
			SupplierService supplierService) {
		this.productRepository = productRepository;
		this.categoryService = categoryService;
		this.supplierService = supplierService;
	}

	/**
	 * FIXME There is a problem about duplicate.
	 * When create a product , product supplier created with it again.
	 * */
	
	public ProductResponse save(ProductSaveRequest request) {
		
		Supplier supplier = supplierService.findById(request.getSupplierId());
		//Supplier supplier = SupplierResponse.from(supplierResponse);
				
		
		Product productToSave = Product.builder()
									   .name(request.getName())
									   .description(request.getDescription())
									   .price(request.getPrice())
									   .unitStock(request.getUnitsStock())
									   .category(categoryService.findById(request.getCategoryId()))
									   .supplier(supplier)
									   .build();
		
		Product fromDb = productRepository.save(productToSave);
		
		return ProductResponse.from(fromDb);
									  

		
	}
	
}
