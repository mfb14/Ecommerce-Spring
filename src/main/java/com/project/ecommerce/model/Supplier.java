/**
 * Supplier.java
 */
package com.project.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 10, 2022 5:20:08 AM
 */
@Entity
public class Supplier extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "phone_number")
	private String phoneNumber;
	@OneToMany(mappedBy = "supplier")
	private List<Product> products;
	
	
}