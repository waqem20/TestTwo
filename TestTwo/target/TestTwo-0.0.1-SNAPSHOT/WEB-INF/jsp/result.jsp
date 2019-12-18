<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>TestOne</title>
</head>
<body>
	<h2>Submitted Student Information</h2>
	<table>
		<tr>
			<td>Name</td>
			<td>${StudentWeb.name}</td>
		</tr>
		<tr>
			<td>Age</td>
			<td>${StudentWeb.age}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${StudentWeb.email}</td>
		</tr>
		<tr>
			<td>Date</td>
			<td>${StudentWeb.date}</td>
		</tr>
		<tr>
			<td><a href="/TestTwo/student">Proceed to edit student page</a></td>
		</tr>
	</table>
</body>
</html>