<%@ page language="java" import="com.model.Product" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('one.jpg');">
<h1>Bidding center</h1><br>
<form action="http://localhost:8082/eauctiondynamic/BiddingServlet" method="get">
<table border="1">
<%  List<Product> productdetails=(List)request.getAttribute("pdetails");
String maxamount=(String)request.getAttribute("amount");%>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Short Description</th>
<th>Starting Price</th>
<th>Last bid Amount</th>
</tr>
<%  
for(Product d: productdetails){
	%>
<tr>
<td><%=d.getProductid()%></td>
<td><%=d.getProductname() %></td>
<td><%=d.getShortdescription() %></td>
<td><%=d.getStartingprice() %></td>
<td><%=maxamount%></td>
<td><input type="text" name="bidamount" placeholder="Enter amount" required></td>
<td><input type="submit" value="bid"></td>
<%}%>
</table><br><br>
 </form>
<br>
<a href="index.html">Logout</a>
</body>
</html> 