<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
<script src="static/js/app.js"></script>
<script src="static/js/controller/student_controller.js"></script>
<script src="static/js/service/student_service.js"></script>

<title>Add a student</title>
</head>
<body ng-app="myApp" ng-controller="StudentController as ctrl">
	<h2>Welcome to the edit student page</h2>
	<br> This is where you can add information about yourself!!!
	<h3>Student Information</h3>
	<div id="forms">
		<form ng-submit="ctrl.submit()" name="studentForm"
			class="form-horizontal">
			<table>
				<tr>
					<td><label>Name: *</label></td>
					<td><input type="text" ng-model="ctrl.student.name"
						placeholder="Enter your name" required /></td>
				</tr>
				<tr>
					<td><label>Age: *</label></td>
					<td><input type="text" ng-model="ctrl.student.age"
						placeholder="Enter your age" required /></td>
				</tr>
				<tr>
					<td><label>Email: *</label></td>
					<td><input type="text" ng-model="ctrl.student.email"
						placeholder="Enter your email" required /></td>
				</tr>
				<tr>
					<td><label>Date: *</label></td>
					<td><input type="text" ng-model="ctrl.student.date"
						placeholder="mm/dd/yyyy" required>
				</tr>
				<tr>
					<td><input type="submit"
						value="{{!ctrl.student.date ? 'Add' : 'Update'}}" id="add"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<input value="Add a Student" type="button"
		onClick="location.href='/TestTwo/studentSync'">
	<br>
	<br>
	<div>
		<span>List of Students </span>
	</div>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Email</th>
				<th>Date</th>
				<th width="50%"></th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="student in ctrl.students">
				<td><span ng-bind="student.id"></span></td>
				<td><span ng-bind="student.name"></span></td>
				<td><span ng-bind="student.age"></span></td>
				<td><span ng-bind="student.email"></span></td>
				<td><span ng-bind="student.date"></span></td>
				<td>
					<button type="button" ng-click="ctrl.edit(student.id)" id="edit" onClick="show()">Edit</button>
					<button type="button" ng-click="ctrl.remove(student.id)">Remove</button>
				</td>
			</tr>
		</tbody>
		</table>
		
		<script type="text/javascript">
		window.onload = function(){
			document.getElementById("forms").style.display='none';
		}
		function show(){
			document.getElementById("forms").style.display='block';
		}
		</script>
	</body>
</html>