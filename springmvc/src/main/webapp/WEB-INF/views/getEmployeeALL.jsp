<%@page import="com.capgemini.springmvc.dto.EmployeePrimaryInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%List<EmployeePrimaryInfo> info = (List<EmployeePrimaryInfo>) request.getAttribute("list");%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%if(info!=null){ %>
	<div>
		<table>
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
			<% for(EmployeePrimaryInfo emp : info) {%>
			<tr>
				<td><%=emp.getId()%></td>
				<td><%=emp.getName() %></td>
				<td><%=emp.getEmail() %></td>
				<td><%=emp.getMobile() %></td>
				<td><%=emp.getJoiningDate() %></td>
				<td><%=emp.getSalary() %></td>
				<td><%=emp.getManagerId() %></td>
				<td><%=emp.getDeptno() %></td>
			</tr>
			<%} %>
			</tbody>
		</table>
		
	</div>
	<%} %>
</body>
</html>