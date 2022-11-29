/**
 * CategoryReposityory.java
 */
package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Category;

/**
 * @author Mustafa Furkan BİLEN
 * @since Nov 29, 2022 4:58:18 PM
 */
@Repository
public interface CategoryReposityory extends JpaRepository<Category, Integer> {

}
