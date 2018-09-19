package com.niit.QuestBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.DealDAO;
import com.niit.Model.Deal;

import junit.framework.TestCase;

public class DealTestCase extends TestCase {
AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
 DealDAO dealDAO = (DealDAO) context.getBean("dealDAO");
 
 public void testfindDealById()
	{
		Deal deal786=dealDAO.findDealById("zozo");
		assertNotNull(deal786);
		String expectedid="zozo";
		String actualid=deal786.getDid();
		assertTrue(expectedid.equals(actualid));
	}

	

	public void testaddDeal() 
	{
		Deal deal867=new Deal();
		deal867.setDid("zozo");
		deal867.setDname("lllllo");
		deal867.setDdescription("lllllp");
		
		
		assertEquals(true,dealDAO.addDeal(deal867));
	}
	
	public void testUpdateDeal() 
	{
		Deal deal793=dealDAO.findDealById("zozo");
		deal793.setDname("zomato");
		deal793.setDdescription("potato");
		assertTrue(deal793.getDid().equals("zozo"));
		dealDAO.updateDeal(deal793);
	}
	
	public void testdeleteDeal()
	{
		Deal deal416=dealDAO.findDealById("zozo");
		assertEquals(true,dealDAO.deleteDeal(deal416.getDid()));
	}

}	

	
	


	

	


