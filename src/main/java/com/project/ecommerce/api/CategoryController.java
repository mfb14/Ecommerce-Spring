/**
 * CategoryController.java
 */
package com.project.ecommerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.business.category.CategoryService;
import com.project.ecommerce.model.Category;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 29, 2022 4:57:27 PM
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Category> save(@RequestBody Category category){
		
		return new ResponseEntity<Category>(categoryService.save(category),HttpStatus.CREATED);
	}
}
