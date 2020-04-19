<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
h2
{
color:#800040;
font-family:arial,sans-serif;
font-weight:bold;
position:absolute;
left:60px;
top:8px;
}
form{
margin-left:25px;
}
form input[type="submit"]{
background-color:#660022;
font-size:20px;
color:white;
width:110px;
margin:80px 30px;
text-decoration:none;
cursor:pointer;
}
</style>
</head>
<body>
<form action="productforsale.jsp">
<input type="submit" value="Retry" >
</form>
<h2>Sorry your product is not uploaded succesfully</h2>
</body>
</html>