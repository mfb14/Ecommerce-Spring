package com.project.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

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
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@CreationTimestamp
	@Column(name = "create_date_time")
	private LocalDateTime createDateTime;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
	//Order can have more orderItems
	@OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
	@Column(name = "order_items")
	private Set<OrderItem> orderItems;
	
	//Customer can have more than one orders
	@ManyToOne
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customer customer;
	
	
}
