<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./added" method="post">
		<table>
			<tr>
				<td><input type="number" name="id" value="id"
					placeholder="enter id"></td>
			</tr>
			<tr>
				<td><input type="text" name="name" value="name"
					placeholder="enter name"></td>
			</tr>
			<tr>
				<td><input type="number" name="mobile" value="mobile"
					placeholder="enter mobile"></td>
			</tr>
			<tr>
				<td><input type="number" name="salary" value="salary"
					placeholder="enter salary"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" value="email"
					placeholder="enter email"></td>
			</tr>
			<tr>
				<td><input type="password" name="password" value="password"
					placeholder="enter password"></td>
			</tr>
			<tr>
				<td><input type="number" name="deptno" value="deptno"
					placeholder="enter deptno"></td>
			</tr>
			<tr>
				<td><input type="date" name="joiningDate" value="joiningDate"
					placeholder="enter joining date"></td>
			</tr>
			<tr>
				<td><input type="number" name="managerId" value="managerId" placeholder="enter managerId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>