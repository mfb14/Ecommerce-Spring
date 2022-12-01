/**
 * ProductSaveRequest.java
 */
package com.project.ecommerce.dto.product;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Mustafa Furkan BİLEN
 * @since Dec 1, 2022 7:22:51 AM
 */
@Data
public class ProductSaveRequest {

	@NotBlank
	private String name;
	private String description;
	@NotBlank
	private BigDecimal price;
	private long unitsStock;
	@NotBlank
	private int categoryId;
	@NotBlank
	private long supplierId;
}
