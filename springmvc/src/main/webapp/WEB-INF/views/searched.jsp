<%@page import="com.capgemini.springmvc.dto.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% EmployeePrimaryInfo info = (EmployeePrimaryInfo)request.getAttribute("info"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if(info!=null){ %>
	<div align="center">
		<table border="1" style="width: 60%">
		<tr style="background: navy; color: white;">
		<th>Employee Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Joining Date</th>
		<th>Salary</th>
		<th>ManagerId</th>
		<th>DeptNo</th>
		</tr>
		<tr>
		<td><%=info.getId()%></td>
		<td><%=info.getName() %></td>
		<td><%=info.getEmail() %></td>
		<td><%=info.getMobile() %></td>
		<td><%=info.getJoiningDate() %></td>
		<td><%=info.getSalary() %></td>
		<td><%=info.getManagerId() %></td>
		<td><%=info.getDeptno() %></td>
		</tr>
		</table>
	</div>
	<%} %>
</body>
</html>