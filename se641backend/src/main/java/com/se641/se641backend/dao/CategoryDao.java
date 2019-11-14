/**
 * 
 */
package com.se641.se641backend.dao;

import java.util.List;

import com.se641.se641backend.model.Category;

/**
 * @author zknab
 *
 */

public interface CategoryDao {
	
	boolean add(Category category);
	
	
	List<Category> categoryList();

	Category get(int id);

}
