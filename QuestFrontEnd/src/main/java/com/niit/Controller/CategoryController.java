package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CategoryDAO;
import com.niit.Model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/category")
	public String showCategory(Model m)
	{
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList", listCategories);
		return "Category";
	}

	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("catname") String catname,@RequestParam("catdescription") String catdescription,Model m)
	{
		Category category=new Category();
		
		category.setCname(catname);
		category.setCdescription(catdescription);
		
		categoryDAO.addCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList", listCategories);
		
		return "Category";
	}
	
	@RequestMapping("/deleteCategory/{cid}")
	public String deleteCategory(@PathVariable("cid") int categoryId,Model m)
	{
		Category category=(Category)categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList", listCategories);
		
		return "Category";
	}
	
	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=(Category)categoryDAO.getCategory(categoryId);
		m.addAttribute("category",category);
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryId") int categoryId,@RequestParam("catname") String catname,@RequestParam("catdesc") String catDesc,Model m)
	{
		Category category=(Category)categoryDAO.getCategory(categoryId);
		
		category.setCname(catname);
		category.setCdescription(catDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList", listCategories);
		
		return "Category";
	}
}
