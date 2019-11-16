/**
 * 
 */
package com.se641.se641backend.dao;

import java.util.List;

import com.se641.se641backend.model.Product;

/**
 * @author zknab
 *
 */
public interface ProductDAO {

	
	
	Product get(int id);
	boolean add(Product product);
	boolean update (Product product);
	boolean delete (Product product);
	
	List<Product> productList();
	List<Product> activeProductList();
	List<Product> activeProductListByCategory(int categoryId); 
	List<Product> getLatestActiveProductList(int count);
	
	

}
