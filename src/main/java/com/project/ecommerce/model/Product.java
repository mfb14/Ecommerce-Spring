package com.project.ecommerce.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{

	private String name;
	private String details;
	private BigDecimal price;
	private Long stockQuantity;
	
	
}
