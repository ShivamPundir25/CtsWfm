package com.eas.dao;

import java.util.List;

import com.eas.model.Product;
import com.eas.model.Transactions;
import com.eas.model.User;

public interface UserDao {

public List<User> getAllCreds();

public void newUserRegistration(User user);

public void addProduct(Product product);

//public Product allProducts(String categoryid);

public List<Product> getProductByCategory(String categoryid);

public List<Transactions> myPurchases();

public List<Transactions> mysales();


}
