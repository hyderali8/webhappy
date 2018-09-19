package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.CartItemDAO;
import com.niit.Model.CartItem;

import com.niit.Model.User;

@Repository
@Transactional
public class CartItemDAOImpl implements CartItemDAO {
	@Autowired
	private SessionFactory sessionFactory;
		public void addToCart(CartItem cartItem) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(cartItem);
		}
		public User getUser(String email) {
			Session session=sessionFactory.getCurrentSession();
			User user=(User)session.get(User.class,email);
			return user;
		}
		public List<CartItem>getCart(String email) {
			Session session=sessionFactory.getCurrentSession();
			//SQL - select * from cartItem where user_email=?
			//cartItem has user, user has email
			Query query=session.createQuery("from CartItem where user.email='"+email+"'");
			//query.setString(0, email);
			List<CartItem> cartItems=query.getResultList();
			return cartItems;
			
		}
		public void removeCartItem(int cartItemId) {
			Session session=sessionFactory.getCurrentSession();
			CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
			session.delete(cartItem);
			
			
		}
		
}
