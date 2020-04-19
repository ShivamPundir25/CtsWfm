package com.eas.model;

import javax.persistence.*;
import com.eas.model.User;
import com.eas.model.Category;

@Entity
@Table(name="Product")
public class Product {

	public Product() {}
	
	//private User user;
//private Category category;
	
	@Id
	private String ProductId;
	@Column
	private String SellerId;
	@Column
	private String CategoryId;
	@Column
	private String ProductName;
	@Column
	private String ShortDescription;
	@Column
	private String DetailedDescription;
	@Column
	private String StartingPrice;
	@Column
	private String BidStartDate;
	@Column
	private String BidEndDate;
	
	
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getSellerId() {
		return SellerId;
	}
	public void setSellerId(String sellerId) {
		SellerId = sellerId;
	}
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getShortDescription() {
		return ShortDescription;
	}
	public void setShortDescription(String shortDescription) {
		ShortDescription = shortDescription;
	}
	public String getDetailedDescription() {
		return DetailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		DetailedDescription = detailedDescription;
	}
	public String getStartingPrice() {
		return StartingPrice;
	}
	public void setStartingPrice(String startingPrice) {
		StartingPrice = startingPrice;
	}
	public String getBidStartDate() {
		return BidStartDate;
	}
	public void setBidStartDate(String bidStartDate) {
		BidStartDate = bidStartDate;
	}
	public String getBidEndDate() {
		return BidEndDate;
	}
	public void setBidEndDate(String bidEndDate) {
		BidEndDate = bidEndDate;
	}
	
	/*
	    @OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="UserId")
		@Column(name="SellerId")
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="CategoryId")
		//@Column(name="CategoryId")
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}	
	
	*/
	
}
