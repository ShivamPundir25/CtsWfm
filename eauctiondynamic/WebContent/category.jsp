<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category form</title>
	<link rel="stylesheet" href="categorystyle.css">
</head>
<body>
<form action="http://localhost:8082/eauctiondynamic/AllProductServlet" method="get">
<label for="categoryid">Choose a Category</label>
<select id="categoryid" name="categoryid" required>
  <option ></option>
  <option value="C0001">Antiques</option>
  <option value="C0002">Jewellery</option>
  <option value="C0003">Art</option>
  <option value="C0004">Electronics</option>
</select>
<input type="submit" value="continue" id="continue">
</form>
<form action="usertype.jsp">
<input type="submit" value="homepage">
</form>
</body>
</html>


