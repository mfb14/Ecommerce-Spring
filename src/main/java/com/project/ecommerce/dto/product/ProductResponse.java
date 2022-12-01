/**
 * ProductResponse.java
 */
package com.project.ecommerce.dto.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;


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
}
