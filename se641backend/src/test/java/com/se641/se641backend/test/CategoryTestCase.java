/**
 * 
 */
package com.se641.se641backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.se641.se641backend.dao.CategoryDao;
import com.se641.se641backend.model.Category;

/**
 * @author zknab
 *
 */
public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDao categoryDAO;
	private Category category;

	/*
	 * Static init Method
	 */
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.se641.se641backend");
		context.refresh();

		categoryDAO = (CategoryDao)context.getBean("categoryDAO");
	
	}
	
/*	@Test
	public void testAddCategory() {
		category = new Category();
		Category category = new Category();
		// Adding first category to list
		category.setName("Mobile");
		category.setDescription("For Mobile");
		category.setImageUrl("CAT_2.png");

		assertEquals("Successfull Added", true, categoryDAO.add(category));	
	}*/

	
/*	@Test
	public void testGetCatregory() {
		category = categoryDAO.get(1);
		assertEquals("Successfull Get a Category by matching  ID : 1", 1, category.getId());	
	}*/
	
	
	// test Update
/*	@Test
	public void testUpdateCatregory() {
		category = categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Successfull Update a Category by matching  ID : TV", true, categoryDAO.update(category));	
	}
	*/
	
/*	@Test
	public void testDeleteCatregory() {
		category = categoryDAO.get(3);
		
		assertEquals("Successfull delete a Category by matching  ID : 3", true, categoryDAO.delete(category));	
	}
	*/
	
/*	@Test
	public void testListCatregory() {
		
		
		assertEquals("Successfull List of categories from table", 3, categoryDAO.categoryList().size());
	}*/
	
	/*
	 * Single test case
	 */
	@Test
	public void testSingleCaseCategory() {
		// NEED TO DO LATER
		
	}

}
