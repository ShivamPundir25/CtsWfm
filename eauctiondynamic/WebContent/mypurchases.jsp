<%@ page language="java" import="com.model.Transactions" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('one.jpg');">
<h2>Purchases</h2>
<table border="1">
<%  List<Transactions> mypurchase=(List)request.getAttribute("purchases");%>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Description</th>
<th>Final Price</th>
</tr>
<%  
for(Transactions p:mypurchase){ %>
<tr>
<td><%=p.getProductid()%></td>
<td><%=p.getProductname()%></td>
<td><%=p.getShortdescription()%></td>
<td><%=p.getBidamount()%></td>
</tr>
<%}%>
</table><br><br>
<form action="usertype.jsp">
<input type="submit" value="homepage">
</form>
</body>
</html> 

