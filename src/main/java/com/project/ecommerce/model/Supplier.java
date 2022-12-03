/**
 * Supplier.java
 */
package com.project.ecommerce.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 10, 2022 5:20:08 AM
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "suppliers")
@Builder
@Setter
public class Supplier extends BaseEntity {

	@Column(name = "name",unique = true)
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
