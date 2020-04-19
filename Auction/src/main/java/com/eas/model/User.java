package com.eas.model;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
@Id
private String UserId;
private String FirstName;
private String LastName;
private String Password;
private String Address;
private String City;
private String State;
private String Pin;
private String Phone;
private String Email;
private String PaypalAccount;
public String getUserId() {
	return UserId;
}
public void setUserId(String userId) {
	UserId = userId;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public String getPin() {
	return Pin;
}
public void setPin(String pin) {
	Pin = pin;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPaypalAccount() {
	return PaypalAccount;
}
public void setPaypalAccount(String paypalAccount) {
	PaypalAccount = paypalAccount;
}
@Override
public String toString() {
	return "User [UserId=" + UserId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Password=" + Password
			+ ", Address=" + Address + ", City=" + City + ", State=" + State + ", Pin=" + Pin + ", Phone=" + Phone
			+ ", Email=" + Email + ", PaypalAccount=" + PaypalAccount + "]";
}
public User() {
	
}
	
	
}

