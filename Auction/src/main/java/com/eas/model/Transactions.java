package com.eas.model;
import javax.persistence.*;

@Entity
@Table(name="transactions")
public class Transactions{
	
	/**
	 * 
	 */
	
	@Id
	private int transactionid;
	@Column
	private String productid;
	@Column
	private String productname;
	@Column
	private String shortdescription;
	@Column
	private String bidderid;
	@Column
	private String sellerid;
	@Column
	private String bidamount;
	@Column
	private String userbiddate;
	
	private Product product;
	private User user;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(String productid, String productname, String shortdescription,
			String bidderid, String sellerid, String bidamount, String userbiddate) {
		
		super();}
	public Transactions(int transactionid, String productid, String productname, String shortdescription,
			String bidderid, String sellerid, String bidamount, String userbiddate) {
		super();
		this.transactionid = transactionid;
		this.productid = productid;
		this.productname = productname;
		this.shortdescription = shortdescription;
		this.bidderid = bidderid;
		this.sellerid = sellerid;
		this.bidamount = bidamount;
		this.userbiddate = userbiddate;
	}
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public String getBidderid() {
		return bidderid;
	}
	public void setBidderid(String bidderid) {
		this.bidderid = bidderid;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getBidamount() {
		return bidamount;
	}
	public void setBidamount(String bidamount) {
		this.bidamount = bidamount;
	}
	public String getUserbiddate() {
		return userbiddate;
	}
	public void setUserbiddate(String userbiddate) {
		this.userbiddate = userbiddate;
	}

	
	
	
}
