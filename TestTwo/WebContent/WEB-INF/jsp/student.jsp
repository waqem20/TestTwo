<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student Page</title>
</head>
<body>
	<h2>Welcome to the student page</h2>
	<h3>Add your information below</h3>
	<br>
	<br>
	<form name="addStudent" method="POST" action="/TestTwo/addStudent">
		<table>
			<tr>
				<td><label>Name: *</label></td>
				<td><input id="name" name="name" type="text"
					placeholder="Enter your name" required /></td>
			</tr>
			<tr>
				<td><label>Age: </label></td>
				<td><input id="age" name="age" type="text"
					placeholder="Enter your age" /></td>
			</tr>
			<tr>
				<td><label>Date: *</label></td>
				<td><input id="date" name="date" type="text"
					placeholder="Enter your date" required></td>
			</tr>
			<tr>
				<td><label>Email: *</label></td>
				<td><input id="email" name="email" type="text"
					placeholder="Enter your email" required /></td>
			</tr>
			<tr>
				<td><button click="add">Add</button></td>
			</tr>
		</table>
	</form>
</body>
</html>