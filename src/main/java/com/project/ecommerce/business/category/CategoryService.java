/**
 * CategoryService.java
 */
package com.project.ecommerce.business.category;

import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Category;
import com.project.ecommerce.repository.CategoryReposityory;


/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 29, 2022 5:01:53 PM
 */
@Service
public class CategoryService {
	
	CategoryReposityory categoryReposityory;
	
	private CategoryService(CategoryReposityory categoryReposityory) {
		this.categoryReposityory = categoryReposityory;
	}

	

	public Category save(Category request) {
		return categoryReposityory.save(request);
	}
	
	public Category findById(Integer id) {
		return categoryReposityory.findById(id).get();
	}
}
