package com.niit.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.UserDAO;
import com.niit.Model.User;
@Repository(value="userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
SessionFactory sessionfactory;


	public boolean addUser(User user) {
		
sessionfactory.getCurrentSession().save(user);
     return true;
	}

	public void ViewUser() {
	List<User> user=sessionfactory.getCurrentSession().createQuery("from User").list();
	for(User us:user)
	{
		System.out.println(us.getUid());
		System.out.println(us.getUname());
		System.out.println(us.getUemail());
		System.out.println(us.getUpwd());
		System.out.println(us.getUmobileno());
		System.out.println(us.getUlocation());
	}
	}
	
	
    public User findUserById(String uid) {
		
		return (User)sessionfactory.getCurrentSession().createQuery("from User where uid='"+uid+"'").uniqueResult();
	}
	
	public boolean updateUser(User user) {
		sessionfactory.getCurrentSession().update(user);
		return true;
	}
	
	public boolean deleteUser(String uid) {
		sessionfactory.getCurrentSession().delete(findUserById(uid));	
		return true;
		
	}

	public <UserDetail> UserDetail getDetail(String trim) {
		// TODO Auto-generated method stub
		return null;
	}
}
