package com.eas.model;


import javax.persistence.*;


@Entity
@Table(name="Category")
public class Category {

	@Id
	private String CategoryId;
	private String CategoryName;
	
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
	public Category() {
		
	}
	
	
}
