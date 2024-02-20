<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Order Burger</h2>
<form method ="get" action="showPage.htm">
<table border="2">
<tr>
<td>Burger Name</td>
<td><form:select path="burger">
<form:option value="" label="--Select--" />
<form:option value="1" label="Veg-Burger" />
<form:option value="2" label="Chicken-Burger" />
<form:option value="3" label="Veg-Crunch-Burger" />
<form:option value="4" label="Chicken-Crunch-Burger" />
</form:select></td>
</tr>
<tr>
<td>Topping Name</td>
<td><form:select path="">
<form:option value="" label="--Select--" />
<form:option value="1" label="Cheese" />
<form:option value="2" label="Dip" />
<form:option value="3" label="Sauce" />
</form:select></td>
</tr>
<tr>
<td>Number of burger</td>
<td><input type ="number" name ="StuRoll"/></td>
</tr>

<tr>
<td><input type ="submit" value ="Order"/></td>
</tr>

</table>

</form>
</center>>
</body>
</html>