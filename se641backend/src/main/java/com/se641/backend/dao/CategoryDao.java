/**
 * 
 */
package com.se641.backend.dao;

import java.util.List;

import com.se641.backend.model.Category;

/**
 * @author zknab
 *
 */

public interface CategoryDao {
	
	List<Category> categoryList();

	Category get(int id);

}
