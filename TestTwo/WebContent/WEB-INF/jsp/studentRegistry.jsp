<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
<script src="static/js/app.js"></script>
<script src="static/js/controller/student_controller.js"></script>
<script src="static/js/service/student_service.js"></script>

<title>Add a student</title>
</head>
<body ng-app="studentRegistryApp" ng-controller="StudentController as ctrl">
	<div style="text-align: center">
	<h2>Welcome To The Student Registry Page</h2>
	</div>
	
	<br>
	<p>To add your student information click on the button below !</p>
	<input value="Add a Student" type="button"
		onClick="location.href='/TestTwo/student'">
	<br>
	<br>
	<div style="text-align: center">
	<p> This is where you can edit information about yourself!!! </p>
	<h3>Student Information</h3>
	<div ng-if="ctrl.edittingStudent" style="text-align: center">
		<form ng-submit="ctrl.updateStudent(student,id)" name="studentForm"
			class="form-horizontal">
			<table>
				<tr>
					<td><label>Name: *</label></td>
					<td><input type="text" ng-model="ctrl.selectedStudent.name"
						placeholder="Enter your name" required /></td>
				</tr>
				<tr>
					<td><label>Age: </label></td>
					<td><input type="text" ng-model="ctrl.selectedStudent.age"
						placeholder="Enter your age" /></td>
				</tr>
				<tr>
					<td><label>Email: *</label></td>
					<td><input type="text" ng-model="ctrl.selectedStudent.email"
						placeholder="Enter your email" required /></td>
				</tr>
				<tr>
					<td><label>Date: *</label></td>
					<td><input type="text" ng-model="ctrl.selectedStudent.date"
						placeholder="mm/dd/yyyy" required>
				</tr>
				<tr>
					<td><input type="submit"
						value="Update" id="add"></td>
				</tr>
			</table>
		</form>
	</div>
	</div>

	<input value="Return back to Homepage" type="button" 
		onClick="location.href='/TestTwo/'">
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
					<button type="button" ng-click="ctrl.editStudent(student.id)">Edit</button>
					<button type="button" ng-click="ctrl.deleteStudent(student.id)">Remove</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>