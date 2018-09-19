package com.niit.DAO;

import java.util.List;

import com.niit.Model.Category;
 
public interface CategoryDAO {
public boolean addCategory(Category category);	
public void ViewCategory();
public Category findCategoryById(String cid);
public boolean updateCategory(Category category);
public boolean deleteCategory(Category category);
public List<Category> listCategories();
public Category getCategory(int categoryId);
public Object deleteCategory(String cid);

}
