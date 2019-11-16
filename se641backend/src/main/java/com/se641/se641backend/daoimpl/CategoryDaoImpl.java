/**
 * 
 */
package com.se641.se641backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.se641.se641backend.dao.CategoryDao;
import com.se641.se641backend.model.Category;

/**
 * @author zknab
 *
 */
@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	/*
	 * Add session to create category
	 */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> categoryList() {
		String getActiveCategory = "FROM Category WHERE is_active = :is_active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(getActiveCategory);
		query.setParameter("is_active", 1);
		
		return query.getResultList();
	}

	@Override
	public Category get(int id) {

		// return a single category by id
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {
			// add category to the DB
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {

		try {
			// Update a single category to the DB
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		try {
			// Update a single category to the DB
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
