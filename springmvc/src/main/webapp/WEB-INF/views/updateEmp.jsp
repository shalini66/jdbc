<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<legend>Update Employee</legend>
	<form action="./updateEmp">
	
	Employee ID:<input type="number" name ="id" required>
	&nbsp;&nbsp;&nbsp;&nbsp;
	Employee Name:<input type="text" name ="name">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="update">
	</form>
	
	</fieldset>
</body>
</html>