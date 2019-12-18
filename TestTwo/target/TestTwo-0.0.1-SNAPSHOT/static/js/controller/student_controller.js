'use strict';

angular.module('myApp').controller('StudentController', ['StudentService', function(StudentService) {
    var self = this;
    self.student={id:null,name:'',age:'',email:'',date:null};
    self.students=[];
    
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    
    fetchAllStudents();
    
    function fetchAllStudents(){
            StudentService.fetchAllStudents()
            .then(function(d) {
                self.students = d.data;
            }
        );
    }

    function createStudent(student){
        StudentService.createStudent(student)
            .then(
            fetchAllStudents,
            function(errResponse){
            	console.error('Error while creating Student');
            }
        ); 
    }

    function updateStudent(student, id){
    	console.log("in the update student");
        StudentService.updateStudent(student, id)
            .then(
            fetchAllStudents,
            function(errResponse){
                console.error('Error while updating Student');
            }
        );
    }
    
    function submit() { 	
        if(self.student.id===null){
            createStudent(self.student);
        }else{
            updateStudent(self.student, self.student.id);
        }
    }
    
    function edit(id){
    	console.log("this the edit button " +id);
        for(var i = 0; i < self.students.length; i++){
            if(self.students[i].id === id) {
            	console.log("make an edit:"+id);
                self.student = angular.copy(self.students[i]);
                self.student.date = self.student.date;
                break;
            }
        }
    }
 
    function remove(id){
        if(self.student.id === id) {//clean form if the student to be deleted is shown there.
            reset();
        }
        deleteStudent(id);
    }
    
    function deleteStudent(id){
        StudentService.deleteStudent(id)
            .then(
            fetchAllStudents,
            function(errResponse){
                console.error('Error while deleting Student');
            }
        );
    }
}]);
