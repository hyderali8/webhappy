package com.niit.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.DAO.ProductDAO;
import com.niit.Model.CartItem;
import com.niit.Model.Product;

@Controller
public class CartController 
{
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable("productId") int productId,Model m,HttpSession session)
	{
		
		Product product=(Product)productDAO.getProduct(productId);
		
		CartItem cart=new CartItem();
		cart.setProductId(product.getPid());
		cart.setProductName(product.getPname());
		cart.setStatus("NA");

		
		return "Cart";
	}
}
