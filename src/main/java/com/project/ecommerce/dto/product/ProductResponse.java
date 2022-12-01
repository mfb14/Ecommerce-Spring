/**
 * ProductResponse.java
 */
package com.project.ecommerce.dto.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.project.ecommerce.model.Product;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Mustafa Furkan BİLEN
 * @since Dec 1, 2022 7:31:53 AM
 */
@SuperBuilder
@Data
public class ProductResponse {

	private LocalDateTime createDateTime;
	private String name;
	private String description;
	private BigDecimal price;
	private Long unitStock;
	private String categoryName;
	private String supplierName;
	
	
	public static ProductResponse from (Product product) {
		
		return ProductResponse.builder()
							  .name(product.getName())
							  .description(product.getDescription())
							  .price(product.getPrice())
							  .unitStock(product.getUnitStock())
							  .categoryName(product.getCategory().getName())
							  .supplierName(product.getSupplier().getName())
							  .createDateTime(product.getCreateDateTime())
							  .build();
	}
}
