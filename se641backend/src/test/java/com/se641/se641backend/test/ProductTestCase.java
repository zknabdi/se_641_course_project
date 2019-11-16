/**
 * 
 */
package com.se641.se641backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.se641.se641backend.dao.ProductDAO;
import com.se641.se641backend.model.Product;

/**
 * @author zknab
 *
 */
public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;
	private Product product;

	/*
	 * Static init Method
	 */
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.se641.se641backend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	@Test
	public void testSingleCaseProduct() {
		// create operation
		product = new Product();

		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));

		// reading and updating the category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the existing record!", true, productDAO.update(product));

		assertEquals("Something went wrong while deleting the existing record!", true, productDAO.delete(product));

		// list
		assertEquals("Something went wrong while fetching the list of products!", 6, productDAO.productList().size());

	}

	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!", 5,
				productDAO.activeProductList().size()); // activeProductList
	}

	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!", 3,
				productDAO.activeProductListByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!", 2,
				productDAO.activeProductListByCategory(1).size());
	}

	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!", 3,
				productDAO.getLatestActiveProductList(3).size());

	}

}
