package com.project.ecommerce.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	@Column(name = "create_date_time")
	private LocalDateTime createDateTime;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	//Many carts has same product
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	private Product product;
	
	
	@OneToOne(targetEntity = Customer.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,name = "customer_id")
	private Customer customer;
	
	
}
