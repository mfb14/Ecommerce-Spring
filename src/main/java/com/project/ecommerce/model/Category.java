package com.project.ecommerce.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	@JsonIgnore
	@Id
	private int id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY
									, cascade = CascadeType.ALL)
	Set<Product> products;
}
