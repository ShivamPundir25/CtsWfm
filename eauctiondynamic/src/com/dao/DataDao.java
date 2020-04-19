package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.model.Product;
import com.model.Transactions;
import com.model.User;

public interface DataDao {
	public default Connection getDataConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Eauctiondynamic","root","shivam");
		}
		catch(Exception e) {
			
		}
		return con;
	}
	public List<User> getAllCreds();
	public int newUserRegistration(User user);
	public int addProduct(Product product);
	public List<Transactions> mySales(String sellerid);
	public List<Product> allProduct(String categoryid);
	public List<Product> productDetails(String productid);
	public List<Transactions> myPurchases(String bidderid);
	public String maxAmount(String productid);
	public int bidTransaction(String productid,String bidderid,String bidamount);
	}