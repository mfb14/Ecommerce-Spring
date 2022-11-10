package com.project.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "unit_stock")
	private Long unitStock;
	@Column(name = "image_url")
	private String imageUrl;
	
	//Category has more than one product
	@ManyToOne
	@JoinColumn(name = "category_id",nullable = false)
	private Category category;
	
	//One product can be in more than one cart
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
	private List<Cart> carts;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id",nullable = false)
	private Supplier supplier;
	
	
	
	
	
}
