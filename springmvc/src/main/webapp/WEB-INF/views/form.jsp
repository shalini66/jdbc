<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="./submitDto" method="post" style="margin-top: 150px; margin-left: 500px">
		<table style="font-size: 20px">
			<tr>
				<td>Id:</td>
				<td><input name="id" type="text" placeholder="enter id"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input name="name" type="text" placeholder="enter name"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name="email" type="text" placeholder="enter email"></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="submit" value="submit" type="submit"
					text-align="center"></td>
			</tr>
		</table>
	</form>
</body>
</html>