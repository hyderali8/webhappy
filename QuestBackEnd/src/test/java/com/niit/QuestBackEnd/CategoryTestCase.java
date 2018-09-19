package com.niit.QuestBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.CategoryDAO;
import com.niit.Model.Category;


import junit.framework.TestCase;

public class CategoryTestCase extends TestCase {
AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
 CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	

	public void testfindCategoryById()
	{
		Category category1=categoryDAO.findCategoryById("jenin");
		assertNotNull(category1);
		String expectedid="jenin";
		String actualid=category1.getCid();
		assertTrue(expectedid.equals(actualid));
	}

	

	public void testaddCategory() 
	{
		Category category2=new Category();
		category2.setCid("jenin");
		category2.setCname("lllllo");
		category2.setCdescription("lllllp");
		
		
		assertEquals(true,categoryDAO.addCategory(category2));
	}

	
	public void testUpdateCategory() 
	{
		Category category8=categoryDAO.findCategoryById("jenin");
		category8.setCname("Dog");
		category8.setCdescription("u");
		assertTrue(category8.getCid().equals("jenin"));
		categoryDAO.updateCategory(category8);
	}

	public void testdeleteCategory()
	{
		Category category5=categoryDAO.findCategoryById("jenin");
		assertEquals(true,categoryDAO.deleteCategory(category5.getCid()));
	}

}
