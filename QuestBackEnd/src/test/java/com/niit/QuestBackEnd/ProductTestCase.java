package com.niit.QuestBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.ProductDAO;
import com.niit.Model.Product;

import junit.framework.TestCase;

public class ProductTestCase extends TestCase {
AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
 ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

	

	public void testfindProductById()
	{
		Product product0=productDAO.findProductById("60fo");
		assertNotNull(product0);
		String expectedid="60fo";
		String actualid=product0.getPid();
		assertTrue(expectedid.equals(actualid));
	}

	public void testaddProduct() 
	{
		Product product01=new Product();
		product01.setPid("60fo");
		product01.setPname("onida");
		product01.setPdescription("veryyyy good");
		product01.setPcost("oo");
		product01.setPquantity("j9j9");
		
		
		assertEquals(true,productDAO.addProduct(product01));
	}
	
	public void testUpdateProduct() 
	{
		Product product001=productDAO.findProductById("60fo");
		product001.setPname("tigersu");
		product001.setPdescription("vi");
		product001.setPcost("3sz");
		product001.setPquantity("vtq");
		assertTrue(product001.getPid().equals("60fo"));
		productDAO.updateProduct(product001);
	}
	
	public void testdeleteProduct()
	{
		Product product0001=productDAO.findProductById("60fo");
		assertEquals(true,productDAO.deleteProduct(product0001.getPid()));
	}
	
}
	

	

	
