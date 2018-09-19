package com.niit.Controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.Model.Category;
import com.niit.Model.Product;

@Controller
public class ProductController 
{

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		Product product=new Product();
		m.addAttribute("product", product);
		
		m.addAttribute("categoryList", this.getAllCategories());
		
		return "Product";
	}
	
	@RequestMapping("/productDisplay")
	public String showAllProducts(Model m)
	{
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "ProductDisplay";
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,Model m)
	{
		
		System.out.println("Product Name:"+product.getPname());
		System.out.println("Product Desc:"+product.getPdescription());
		
		productDAO.addProduct(product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		m.addAttribute("categoryList", this.getAllCategories());
		
		return "Product";
	}
	
	public LinkedHashMap<String,String> getAllCategories()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		
		LinkedHashMap<String,String> categoryList=new LinkedHashMap<String,String>();
		
		for(Category category:listCategories)
		{
			categoryList.put(category.getCid(), category.getCname());
		}
		
		return categoryList;
	}
}
