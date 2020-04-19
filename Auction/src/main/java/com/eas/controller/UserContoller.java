package com.eas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eas.model.Product;
import com.eas.model.User;
import com.eas.services.UserService;
import com.eas.model.Transactions;


@Controller
public class UserContoller {
	
	@Autowired
	private UserService userService;
	
//first request will redirect here
@RequestMapping(value="/")
public ModelAndView homePage(ModelAndView model) throws IOException
{
	model.setViewName("home");
	return model;
}	

// the request is forwarded to home page
@RequestMapping(value="/homepage")
public ModelAndView homePage1(ModelAndView model) throws IOException
{
    model.setViewName("home");
	return model;
}	

//it checks for login validation 
@RequestMapping(value="/loginValidation")
public String validation(@RequestParam("userid") String userid,@RequestParam("password") String password)
{
	//getting all credentials from user table
	List<User> listUser=userService.getAllCreds();
	boolean flag = false;
	
	//checking whether the user is valid or not
	for(User u: listUser) {
		if(u.getUserId().equals(userid) && u.getPassword().equals(password)) {
			flag=true;
			break;
		}
	}
	if(flag)
	{
		//if creds are valid it will redirect to usertype page
		return "usertype";
	 }
	else
	{
		//if creds are invalid it will redirect to loginfailure page
		return "loginfailure";	 
     }
}

//gets redirected to usertype-welcomepage 
@RequestMapping(value="/welcomepage")
public ModelAndView welcomepage(ModelAndView model)
{   
	model.setViewName("usertype");
	return model;
	}

//it will redirect to registration page
@RequestMapping(value="/registration")
public ModelAndView registration(ModelAndView model)
{
	model.setViewName("registration");
	return model;
	}	

//when a new user will enter the details in registration form then this method will invoke 
//and insert the values in the user table  
@RequestMapping(value = "/newUserRegistration", method = RequestMethod.POST)
public ModelAndView newUserRegistration(ModelAndView model,
		@RequestParam("userid") String userid,
		@RequestParam("password") String password,
		@RequestParam("repassword") String repassword,
		@RequestParam("firstname") String firstname,
		@RequestParam("lastname") String lastname,
		@RequestParam("address") String address,
		@RequestParam("city") String city,
		@RequestParam("state") String state,
		@RequestParam("pin") String pin,
		@RequestParam("phone") String phone,
		@RequestParam("email") String email,
		@RequestParam("paypalaccount") String paypalaccount) {		
	//the values get inserted into the user table if the password and repassword matches
	      if(password.equals(repassword)) {
		   User user = new User();
		   user.setUserId(userid);
		   user.setFirstName(firstname);
		   user.setLastName(lastname);
		   user.setPassword(password);
		   user.setAddress(address);
		   user.setCity(city);
		   user.setState(state);
		   user.setPin(pin);
		   user.setPhone(phone);
		   user.setEmail(email);
		   user.setPaypalAccount(paypalaccount);
	      userService.newUserRegistration(user);
	      model.setViewName("registrationSuccess");
          return model;
	      }
	      else
	      {
	    	  //if password and repassword are not matched then it will redirect to registrationFailure page 
	    	  model.setViewName("registrationFailure");
	          return model;
	      }
}

//the page where we can enter the details of the product which are to be sold
@RequestMapping(value="/productforsale")
public ModelAndView productforsale(ModelAndView model)
{
	model.setViewName("productforsale");
	return model;
}	

//insertion of product details into product table
@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
public ModelAndView addProduct(ModelAndView model,
		@RequestParam("productid") String productid,
		@RequestParam("sellerid") String sellerid,
		@RequestParam("categoryid") String categoryid,
		@RequestParam("productname") String productname,
		@RequestParam("shortdescription") String shortdescription,
		@RequestParam("detailedescription") String detailedescription,
		@RequestParam("startingprice") String startingprice,
		@RequestParam("bidstartdate") String bidstartdate,
		@RequestParam("bidenddate") String bidenddate) {
	    Product product = new Product();
	    product.setProductId(productid);
	    product.setSellerId(sellerid);
	    product.setCategoryId(categoryid);
	    product.setProductName(productname);
	    product.setShortDescription(shortdescription);
	    product.setDetailedDescription(detailedescription);
	    product.setStartingPrice(startingprice);
	    product.setBidStartDate(bidstartdate);
	    product.setBidEndDate(bidenddate);
	    userService.addProduct(product);
	    model.setViewName("productSuccess");
        return model;
	      
}

@RequestMapping(value="/category")
public ModelAndView category(ModelAndView model)
{
	model.setViewName("category");
	return model;
}

//products are displayed by category
@RequestMapping(value="/allProducts")
public ModelAndView getProductByCategory(ModelAndView model,@RequestParam("categoryid") String categoryid) throws IOException
{
	List<Product> allProducts=userService.getProductByCategory(categoryid);
	 model.addObject("allProducts",allProducts);
   model.setViewName("productsavailable");
     return model;
}	

//redirect to mypurchases
@RequestMapping(value="/mypurchases")
public ModelAndView mypurchases(ModelAndView model)
{
List<Transactions> mypurchases= userService.myPurchases();
	model.setViewName("mypurchases");
	return model;
	}
//redirect to sales...
@RequestMapping(value="/mysales")
public ModelAndView mysales(ModelAndView model)
{List<Transactions> mysales= userService.mysales();
	model.setViewName("mysales");
	return model;
	}
//will display success
@RequestMapping(value="/success")
public ModelAndView success(ModelAndView model)
{
	model.setViewName("success");
	return model;
	}
}
