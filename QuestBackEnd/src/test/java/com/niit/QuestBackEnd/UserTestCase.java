package com.niit.QuestBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.UserDAO;
import com.niit.Model.User;


import junit.framework.TestCase;

public class UserTestCase extends TestCase {
AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
 UserDAO userDAO = (UserDAO) context.getBean("userDAO");

	

 public void testfindUserById()
	{
		User user2=userDAO.findUserById("gog");
		assertNotNull(user2);
		String expectedid="gog";
		String actualid=user2.getUid();
		assertTrue(expectedid.equals(actualid));
	}

	

	public void testaddUser() 
	{
		User user7=new User();
		user7.setUid("gog");
		user7.setUname("zz");
		user7.setUemail("555");
		user7.setUpwd("kkk");
		user7.setUmobileno("888");
		user7.setUlocation("vvvv");
		
		
		assertEquals(true,userDAO.addUser(user7));
	}

	public void testUpdateUser() 
	{
		User user18=userDAO.findUserById("gog");
		user18.setUname("mea");
		user18.setUemail("perfec");
		user18.setUpwd("r");
		user18.setUmobileno("000");
		user18.setUlocation("ff");
		assertTrue(user18.getUid().equals("gog"));
		userDAO.updateUser(user18);
	}
	
	public void testdeleteUser()
	{
		User user15=userDAO.findUserById("gog");
		assertEquals(true,userDAO.deleteUser(user15.getUid()));
	}
	
	}
