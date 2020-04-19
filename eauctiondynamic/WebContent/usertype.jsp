<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserType form</title>
<link rel="stylesheet" href="usertypestyle.css">
</head>
<body>
<h3>Successfully, Logged-in</h3><br><br><br>
<form action="productforsale.jsp" >
<input type="submit" value="Sell the Product">
</form> <br> <br>

<form action="category.jsp">
<input type="submit" value="Buy the Product">
</form> <br> <br>

<form action="http://localhost:8082/eauctiondynamic/MySalesServlet" method="get">
<input type="submit" value="My sales">
</form> <br> <br>

<form action="http://localhost:8082/eauctiondynamic/MyPurchasesServlet" method="get">
<input type="submit" value="My purchases">
</form> <br> <br>

<form action="index.html">
<input type="submit" value="Logout" id="logout">
</form>

</body>
</html>