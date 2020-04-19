package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;
import com.model.Transactions;
import com.model.User;


public class DataDaoImpl implements DataDao{

	@Override
	public List<User> getAllCreds() {
		// TODO Auto-generated method stub
		Connection con = getDataConnection();
		Statement st = null;
		ResultSet rs = null;
		List<User> list = new ArrayList();
		try {
			 st = con.createStatement();
			rs = st.executeQuery("select UserId,password from User");
			while(rs.next()) {
				User user = new User();
				
				user.setUserid(rs.getString(1));
				user.setPassword(rs.getString(2));
				list.add(user);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public int newUserRegistration(User user) {
		// TODO Auto-generated method stub
		Connection con = getDataConnection();
		PreparedStatement pst ;
		int result = 0;
		String sql = "insert into user values (?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
		pst = con.prepareStatement(sql);
		pst.setString(1, user.getUserid());
		pst.setString(2, user.getFirstname());
		pst.setString(3, user.getLastname());
		pst.setString(4, user.getPassword());
		pst.setString(5, user.getAddress());
		pst.setString(6, user.getCity());
		pst.setString(7, user.getState());
		pst.setString(8, user.getPin());
		pst.setString(9, user.getPhone());
		pst.setString(10, user.getEmail());
		pst.setString(11, user.getPaypalaccount());

		result = pst.executeUpdate();

		}
		catch(Exception e) {
		System.out.println(e);
		}


		return result;
		}

	@Override
	public int addProduct(Product product) {
		Connection con = getDataConnection();
		PreparedStatement pst ;
		int result = 0;
		String sql = "insert into product values (?,?,?,?,?,?,?,?,?)";
		try
		{
		pst = con.prepareStatement(sql);
		pst.setString(1, product.getProductid());
		pst.setString(2, product.getSellerid());
		pst.setString(3, product.getCategoryid());
		pst.setString(4, product.getProductname());
		pst.setString(5, product.getShortdescription());
		pst.setString(6, product.getDetailedescription());
		pst.setString(7, product.getStartingprice());
		pst.setString(8, product.getBidstartdate());
		pst.setString(9, product.getBidenddate());
		

		result = pst.executeUpdate();

		}
		catch(Exception e) {
		System.out.println(e);
		}


		return result;
		}

	@Override
	public List<Transactions> mySales(String sellerid) {
		Connection con = getDataConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Transactions> list= new ArrayList();
		//list=null;
		//change it according to transaction
		try {
			 //String sql="select transactionid, sellerid, bidderid, productid, max(bidamount) from transactions where sellerid=? group by productid";
			String sql="select transactionid, productid, productname, shortdescription, bidderid, sellerid, max(bidamount),UserBidDate from transactions where sellerid=? group by productid";
			 pst = con.prepareStatement(sql);
			 pst.setString(1, sellerid);
       		 rs = pst.executeQuery();
       		 
       		 while(rs.next()) {
           		 Transactions s=new Transactions();
           		 s.setTransactionid(Integer.parseInt(rs.getString(1)));
           		 s.setProductid(rs.getString(2));
           		 s.setProductname(rs.getString(3));
           		 s.setShortdescription(rs.getString(4));
           		 String bid=rs.getString(5);
           	 	 s.setBidderid(bid);
           	 	 s.setSellerid(rs.getString(6));
           		 s.setBidamount(rs.getString(7));
           		 s.setUserbiddate(rs.getString(8));
           		 list.add(s);
           		 }
       	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	return list;
		
		
	}

	@Override
	public List<Product> allProduct(String categoryid) {
		Connection con = getDataConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Product> list= new ArrayList();
		//list=null;
		
		try {
			 String sql="select * from product where categoryid=?";
			 pst = con.prepareStatement(sql);
			 pst.setString(1, categoryid);
       		 rs = pst.executeQuery();
       		 while(rs.next())
       		 {
       		 Product p=new Product();
       		 p.setProductid(rs.getString(1));
       		 p.setSellerid(rs.getString(2));
       		 p.setCategoryid(rs.getString(3));
       	 	 p.setProductname(rs.getString(4));
       		 p.setShortdescription(rs.getString(5));
       		 p.setDetailedescription(rs.getString(6));
       		 p.setStartingprice(rs.getString(7));
       		 p.setBidstartdate(rs.getString(8));
       		 p.setBidenddate(rs.getString(9));
       		 list.add(p);
       		 }
		}
		catch(Exception e) {
			System.out.println(e);
		}
	return list;
		
		
	}

	@Override
	public List<Product> productDetails(String productid) {
		Connection con = getDataConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Product> list= new ArrayList();
		//list=null;
		
		try {
			 String sql="select * from product where productid=?";
			 pst = con.prepareStatement(sql);
			 pst.setString(1, productid);
       		 rs = pst.executeQuery();
       		 while(rs.next())
       		 {
       		 Product p=new Product();
       		 p.setProductid(rs.getString(1));
       		 p.setSellerid(rs.getString(2));
       		 p.setCategoryid(rs.getString(3));
       	 	 p.setProductname(rs.getString(4));
       		 p.setShortdescription(rs.getString(5));
       		 p.setDetailedescription(rs.getString(6));
       		 p.setStartingprice(rs.getString(7));
       		 p.setBidstartdate(rs.getString(8));
       		 p.setBidenddate(rs.getString(9));
       		 list.add(p);
       		 }
		}
		catch(Exception e) {
			System.out.println(e);
		}
	return list;
		
		
	
	}

	@Override
	public List<Transactions> myPurchases(String bidderid) {
		Connection con = getDataConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Transactions> list= new ArrayList();
		
		try {
              String sql= "select * from transactions where bidderid =? AND bidamount in(select max(bidamount) from transactions group by productid)";
			 pst = con.prepareStatement(sql);
			 pst.setString(1, bidderid);
       		 rs = pst.executeQuery();
       		
       		  while(rs.next()) {
       		 Transactions t=new Transactions();
       		 t.setTransactionid(Integer.parseInt(rs.getString(1)));
       		 t.setProductid(rs.getString(2));
       		 t.setProductname(rs.getString(3));
       		 t.setShortdescription(rs.getString(4));
       		 String bid=rs.getString(5);
       	 	 t.setBidderid(bid);
       	 	 t.setSellerid(rs.getString(6));
       		 t.setBidamount(rs.getString(7));
       		 t.setUserbiddate(rs.getString(8));
       		 list.add(t);
       		 }
       	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	return list;
	}

	@Override
	public String maxAmount(String productid) {
		Connection con = getDataConnection();
		PreparedStatement pst = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String max=null;
		
		
		try {
			 String sql1="select startingprice from product where productid=?";
			 pst = con.prepareStatement(sql1);
			 pst.setString(1, productid);
       		 rs1 = pst.executeQuery();
       		 rs1.next();
       		 int result1=Integer.parseInt(rs1.getString(1));
       		 String sql2="select max(bidamount) from transactions where productid=?";
			 pst = con.prepareStatement(sql2);
			 pst.setString(1, productid);
      		 rs2 = pst.executeQuery();
      		 rs2.next();
      		 String str2=rs2.getString(1);
      		 if(str2==null) 
      			max=rs1.getString(1);
      		  else {
      			 int result2=Integer.parseInt(rs2.getString(1));
      			if(result1>result2)
         			 max=rs1.getString(1);
         		 else
         			max=rs2.getString(1);
          	      } 
      		}
      		 
		
		catch(Exception e) {
			System.out.println(e);
		}
	return max;
	}

	@Override
	public int bidTransaction(String productid,String bidderid, String bidamount) {
		Connection con = getDataConnection();
		PreparedStatement pst ;
		int result = 0;
		ResultSet rs = null;
		try
		{
		String sql1="select * from product where productid=?";
		 pst = con.prepareStatement(sql1);
		 pst.setString(1, productid);
  		 rs = pst.executeQuery();
  		 rs.next();
  		 String pid=(rs.getString(1));
  		 String sid=(rs.getString(2));
  		 String cid=(rs.getString(3));
  		 String pname=(rs.getString(4));
  		String sd=(rs.getString(5));
  		String dd=(rs.getString(6));
  		String sp=(rs.getString(7));
  		String bsd=(rs.getString(8));
  		String bed=(rs.getString(9));
  		 
  		String sql2 = "insert into Transactions(ProductId,ProductName,ShortDescription,BidderId,SellerId,BidAmount,UserBidDate) values (?,?,?,?,?,?,?)";
		
		pst = con.prepareStatement(sql2);
		//pst.setString(1,"T0026");
		pst.setString(1, pid);
		pst.setString(2,pname);
		pst.setString(3,sd);
		pst.setString(4, bidderid);
		pst.setString(5, sid);
		pst.setString(6, bidamount);
		pst.setString(7,"2020-04-06");
		result = pst.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}


		return result;
		}


	
}
		
	
	


