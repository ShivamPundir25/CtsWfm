<%@ page language="java" import="com.model.Product" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('one.jpg');">
<h1>Available Products..</h1><br>
 <form action="http://localhost:8082/eauctiondynamic/ProductDetails" method="get">
<table border="1">
<%  List<Product> allproducts=(List)request.getAttribute("products");%>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Short Description</th>
<th>Starting Price</th>
<th>Select a product</th>
</tr>
<% 
for(Product p: allproducts)
{
%>

<tr>
<td><%=p.getProductid()%></td>
<td><%=p.getProductname() %></td>
<td><%=p.getShortdescription() %></td>
<td><%=p.getStartingprice() %></td>
<!--  <td><input type="submit" value="select" name="<%=p.getProductid()%>"></td>-->
<td><button name="productid" type="submit" value="<%=p.getProductid()%>">select</button></td>
</tr>

<%}%>
</table><br><br>
 </form>
<br>
<a href="category.jsp">Select another category</a><br><br>


</body>
</html> 