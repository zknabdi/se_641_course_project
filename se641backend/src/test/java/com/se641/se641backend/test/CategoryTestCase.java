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
	
	@Test
	public void testAddCategory() {
		category = new Category();
		Category category = new Category();
		// Adding first category to list
		category.setName("Mobile");
		category.setDescription("For Mobile");
		category.setImageUrl("CAT_2.png");

		assertEquals("Successfull Added", true, categoryDAO.add(category));


		
		
	}

}
