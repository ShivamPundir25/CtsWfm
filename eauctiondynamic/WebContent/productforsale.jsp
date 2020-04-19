<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Product form</title>
	<link rel="stylesheet" href="productforsalestyle.css">
</head>
<body>
	<h1>ADD PRODUCT DETAILS</h1>
	
	<form action="http://localhost:8082/eauctiondynamic/AddProductServlet" method="get">

       <label for="productid">Product Id</label>
		<input type="text" name="productid" id="productid" required>
		
		<label for="categoryid">Category</label>
<select id="categoryid" name="categoryid" required>
  <option ></option>
  <option value="C0001">Antiques</option>
  <option value="C0002">Jewellery</option>
  <option value="C0003">Art</option>
  <option value="C0004">Electronics</option>
</select>
		<label for="productname">Product Name</label>
		<input type="text" name="productname" id="productname" required>

		<label for="shortdescription">Short Description</label>
		<input type="text" name="shortdescription" id="shortdescription" required>

		<label for="detailedescription">Detail Description</label>
		<textarea rows="10" cols="25" name="detailedescription" id="detailedescription"></textarea>		

		<label for="startingprice">Starting Price</label>
		<input type="number" name="startingprice" id="startingprice" required>

		<label for="bidstartdate">BidStartDate</label>
		<input type="date" name="bidstartdate" id="bidstartdate" required>

		<label for="bidenddate">BidEndDate</label>
		<input type="date" name="bidenddate" id="bidenddate" required>

		<input type="submit" value="Upload">
		<a href="index.html">Logout</a>	
		</form> 
		
</body>
</html>