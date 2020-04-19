<%@ page language="java"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins:200,300,400');
body
{
margin:0;
padding:0;
background-image:url('one.jpg');
background-size:cover;
background-position:center;
background-repeat:no-repeat;
background-attachment:fixed;
font-family:'Poppins',sans-serif;
}
h3{
margin:2px;
color:660022;}

input:hover[type="submit"]{
background:#ffb3b3;}




</style>
</head>
<body>
<form  action="http://localhost:8082/eauctiondynamic/MyPurchasesServlet" method="get">
Enter your userid to see your purchases:<input type="text" name="bidderid"><br> 
<input type="submit" value="show">
</form>
</body>
</html>