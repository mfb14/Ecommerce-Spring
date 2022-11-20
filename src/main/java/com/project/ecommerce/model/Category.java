package com.project.ecommerce.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY
									, cascade = CascadeType.ALL)
	Set<Product> products;
}
