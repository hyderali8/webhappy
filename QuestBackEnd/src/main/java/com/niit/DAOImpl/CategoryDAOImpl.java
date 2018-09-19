package com.niit.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.CategoryDAO;
import com.niit.Model.Category;
@Repository(value="categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
SessionFactory sessionfactory;
	
	
	public boolean addCategory(Category category) {
		
sessionfactory.getCurrentSession().save(category);
   return true;
	}
	
	public void ViewCategory() {
	List<Category> category=sessionfactory.getCurrentSession().createQuery("from Category").list();
	for(Category ct:category)
	{
		System.out.println(ct.getCid());
		System.out.println(ct.getCname());
		System.out.println(ct.getCdescription());
		
	}
	}
		
    public Category findCategoryById(String cid) {
		
		return (Category)sessionfactory.getCurrentSession().createQuery("from Category where cid='"+cid+"'").uniqueResult();
	}
	
	public boolean updateCategory(Category category) {
		sessionfactory.getCurrentSession().update(category);
		return true;
	}
	
	public Object deleteCategory(String cid) {
		sessionfactory.getCurrentSession().delete(findCategoryById(cid));	
		return true;
	
	}

	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Category> listCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}	



