package com.model;

public class Product {
private	String productid;
private String sellerid;
private	String categoryid;
private String productname;
private String shortdescription;
private String detailedescription;
private String startingprice;
private String bidstartdate;
private String bidenddate;

public Product() {}


public Product(String productid, String sellerid, String categoryid, String productname, String shortdescription,
		String detailedescription, String startingprice, String bidstartdate, String bidenddate) {
	super();
	this.productid = productid;
	this.sellerid = sellerid;
	this.categoryid = categoryid;
	this.productname = productname;
	this.shortdescription = shortdescription;
	this.detailedescription = detailedescription;
	this.startingprice = startingprice;
	this.bidstartdate = bidstartdate;
	this.bidenddate = bidenddate;
}


public String getProductid() {
	return productid;
}

public void setProductid(String productid) {
	this.productid = productid;
}

public String getSellerid() {
	return sellerid;
}

public void setSellerid(String sellerid) {
	this.sellerid = sellerid;
}

public String getCategoryid() {
	return categoryid;
}

public void setCategoryid(String categoryid) {
	this.categoryid = categoryid;
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

public String getDetailedescription() {
	return detailedescription;
}

public void setDetailedescription(String detailedescription) {
	this.detailedescription = detailedescription;
}

public String getStartingprice() {
	return startingprice;
}

public void setStartingprice(String startingprice) {
	this.startingprice = startingprice;
}

public String getBidstartdate() {
	return bidstartdate;
}

public void setBidstartdate(String bidstartdate) {
	this.bidstartdate = bidstartdate;
}

public String getBidenddate() {
	return  bidenddate;
}

public void setBidenddate(String bidenddate) {
	this.bidenddate = bidenddate;
}


}
