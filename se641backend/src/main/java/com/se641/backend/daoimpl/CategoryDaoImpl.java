/**
 * 
 */
package com.se641.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.se641.backend.dao.CategoryDao;
import com.se641.backend.model.Category;

/**
 * @author zknab
 *
 */
@Repository("categoryDAO")
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		// Adding first category to list
		category.setId(1);
		category.setName("Televession");
		category.setDescription("For televesion");
		category.setImageUrl("CAT_1.png");

		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("For Mobile");
		category.setImageUrl("CAT_2.png");

		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("For Laptop");
		category.setImageUrl("CAT_3.png");

		categories.add(category);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.se641.backend.dao.CategoryDao#categoryList()
	 */
	@Override
	public List<Category> categoryList() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {

		// getting list of the category
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
