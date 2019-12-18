'use strict';

angular.module('studentRegistryApp').controller('StudentController', ['StudentService', '$log', function(StudentService, $log) {
    var self = this;
    self.student={id:null,name:'',age:'',email:'',date:null};
    self.selectedStudent={id:null,name:'',age:'',email:'',date:null};
    self.students=[];
    self.edittingStudent=false;
    
    self.$log = $log;
    
    self.editStudent = editStudent;
    self.deleteStudent = deleteStudent;
    self.updateStudent = updateStudent;
    self.createStudent = createStudent;
    
    fetchAllStudents();
    
    function fetchAllStudents(){
            StudentService.fetchAllStudents()
            .then(function(response) {
                self.students = response.data;
            }
        );
    }

    function createStudent(student){
        StudentService.createStudent(student)
            .then(
            fetchAllStudents,
            function(errResponse){
            	self.$log.error('Error while creating Student');
            }
        ); 
    }

    function updateStudent(selectedStudent, id){
    	self.$log.log("In the update Student controller",self.selectedStudent, self.selectedStudent.id);
        StudentService.updateStudent(self.selectedStudent, self.selectedStudent.id)
            .then(
            fetchAllStudents,
            function(errResponse){
            	self.$log.error('Error while updating Student', errResponse);
            }
        );
    	self.edittingStudent = false;

    }
    
    function editStudent(id){
    	self.$log.log("Clicked the edit functionality");
    	
    	var studentByID = self.selectedStudent = self.students.find(function(studentInArray) {
   		self.$log.log(studentInArray.id === id);
   		self.$log.log(self.student);   		
   		return studentInArray.id === id;
    	});
    	
    	self.selectedStudent = angular.copy(studentByID);
    	self.edittingStudent = true;
    }
    
    function deleteStudent(id){
        StudentService.deleteStudent(id)
            .then(
            fetchAllStudents,
            function(errResponse){
            	self.$log.error('Error while deleting Student');
            }
        );
    }
}]);