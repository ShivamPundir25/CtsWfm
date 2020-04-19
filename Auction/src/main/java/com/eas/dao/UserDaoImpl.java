package com.eas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eas.model.Product;
import com.eas.model.Transactions;
import com.eas.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@SuppressWarnings("unchecked")
	public List<User> getAllCreds() {
		
		return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}
	public void newUserRegistration(User user) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	

	@SuppressWarnings("unchecked")
	public List<Product> getProductByCategory(String categoryid) {
		// TODO Auto-generated method stub
		
	   return sessionFactory.getCurrentSession().createQuery("from Product p where p.CategoryId="+categoryid).list();
	  
	}
	@SuppressWarnings("unchecked")
	public List<Transactions> myPurchases() {
		// TODO Auto-generated method stub
		String hql= "select * from transactions where bidderid =? AND bidamount in(select max(bidamount) from transactions group by productid";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	@SuppressWarnings("unchecked")
	public List<Transactions> mysales() {
		// TODO Auto-generated method stub
		String hql="select transactionid, productid, productname, shortdescription, bidderid, sellerid, max(bidamount),UserBidDate from transactions where sellerid=? group by productid";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
