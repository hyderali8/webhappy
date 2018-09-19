package com.niit.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.ProductDAO;
import com.niit.Model.Product;
@Repository(value="productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
SessionFactory sessionfactory;
	
	
	public boolean addProduct(Product product) {
		
sessionfactory.getCurrentSession().save(product);
   return true;
	}
	
	public void ViewProduct() {
	List<Product> product=sessionfactory.getCurrentSession().createQuery("from Product").list();
	for(Product pt:product)
	{
		System.out.println(pt.getPid());
		System.out.println(pt.getPname());
		System.out.println(pt.getPdescription());
		System.out.println(pt.getPcost());
		System.out.println(pt.getPquantity());
	}
	}
	
    public Product findProductById(String pid) {
		
		return (Product)sessionfactory.getCurrentSession().createQuery("from Product where pid='"+pid+"'").uniqueResult();
	}
	
	public boolean updateProduct(Product product) {
		sessionfactory.getCurrentSession().update(product);
		return true;
	}
	
	public boolean deleteProduct(String pid) {
		sessionfactory.getCurrentSession().delete(findProductById(pid));	
		return true;

	}

	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}	
	


