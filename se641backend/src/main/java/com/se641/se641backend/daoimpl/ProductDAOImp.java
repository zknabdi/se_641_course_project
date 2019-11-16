/**
 * 
 */
package com.se641.se641backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.se641.se641backend.dao.ProductDAO;
import com.se641.se641backend.model.Product;

/**
 * @author zknab
 *
 */
@Repository("productDAO")
@Transactional
public class ProductDAOImp implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.se641.se641backend.dao.ProductDAO#get(int)
	 */
	@Override
	public Product get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id)); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.se641.se641backend.dao.ProductDAO#add(com.se641.se641backend.model.Product)
	 */
	@Override
	public boolean add(Product product) {
		try {
			// add Product to the DB
			sessionFactory.getCurrentSession().persist(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.se641.se641backend.dao.ProductDAO#update(com.se641.se641backend.model.Product)
	 */
	@Override
	public boolean update(Product product) {
		try {
			// Update a single product to the DB
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.se641.se641backend.dao.ProductDAO#delete(com.se641.se641backend.model.Product)
	 */
	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			// Update a single product to the DB
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.se641.se641backend.dao.ProductDAO#productList()
	 */
	@Override
	public List<Product> productList() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product", Product.class)
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.se641.se641backend.dao.ProductDAO#activeProductList()
	 */
	@Override
	public List<Product> activeProductList() {
		String selectActivePr = "FROM Product WHERE active =:active"; // from entity name
		return sessionFactory.getCurrentSession()
				.createQuery(selectActivePr, Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.se641.se641backend.dao.ProductDAO#activeProductListByCategory(int)
	 */
	@Override
	public List<Product> activeProductListByCategory(int categoryId) {
		String selectActivePrByCateg = "FROM Product WHERE active =:active AND categoryId =:categoryId"; // from entity name
		return sessionFactory.getCurrentSession()
				.createQuery(selectActivePrByCateg, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.se641.se641backend.dao.ProductDAO#getLatestActiveProductList(int)
	 */
	@Override
	public List<Product> getLatestActiveProductList(int count) {
		String selectFromPRD = "FROM Product WHERE active =:active ORDER BY id"; // from entity name
		return sessionFactory.getCurrentSession()
				.createQuery(selectFromPRD, Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
