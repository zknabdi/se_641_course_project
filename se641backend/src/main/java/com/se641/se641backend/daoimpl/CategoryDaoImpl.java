/**
 * 
 */
package com.se641.se641backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.se641.se641backend.model.Category;
import com.se641.se641backend.dao.CategoryDao;

/**
 * @author zknab
 *
 */
@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();
	/*
	 *  Add session to create category
	 */
	@Autowired
	private SessionFactory sessionFactory;

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

	@Override
	@Transactional // transaction
	public boolean add(Category category) {
		
		try {
			//add category to the DB
			sessionFactory.getCurrentSession().persist(category);
			return true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
