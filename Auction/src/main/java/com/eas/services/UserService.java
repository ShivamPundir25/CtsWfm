package com.eas.services;

import java.util.List;

import com.eas.model.Product;
import com.eas.model.Transactions;
import com.eas.model.User;

public interface UserService {

	public List<User> getAllCreds();
	public  void newUserRegistration(User user);
	public void addProduct(Product product);
	public List<Product> getProductByCategory(String categoryid);
	public List<Transactions> myPurchases();
	public List<Transactions> mysales();
}
