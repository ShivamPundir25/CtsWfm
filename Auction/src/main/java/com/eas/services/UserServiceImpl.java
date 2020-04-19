package com.eas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eas.dao.UserDao;
import com.eas.model.Product;
import com.eas.model.Transactions;
import com.eas.model.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public List<User> getAllCreds() {
		// TODO Auto-generated method stub
		return userDao.getAllCreds();
	}
	
	@Transactional
	public void newUserRegistration(User user) {
		// TODO Auto-generated method stub
		userDao.newUserRegistration(user);
	}

	@Transactional
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		userDao.addProduct(product);
	}
	
	@Transactional
	public List<Product> getProductByCategory(String categoryid) {
		// TODO Auto-generated method stub
		return userDao.getProductByCategory(categoryid);
	}
	@Transactional
	public List<Transactions> myPurchases() {
		// TODO Auto-generated method stub
		return userDao.myPurchases();
	}
	@Transactional
	public List<Transactions> mysales() {
		// TODO Auto-generated method stub
		return userDao.mysales();
	}

}
