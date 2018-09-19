package com.niit.DAO;

import java.util.List;

import com.niit.Model.Product;

public interface ProductDAO {
public boolean addProduct(Product product);
public void ViewProduct();
public Product findProductById(String pid);
public boolean updateProduct(Product product);
public boolean deleteProduct(String pid);
public List<Product> listProducts();
public Product getProduct(int productId);

}
