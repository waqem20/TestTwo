'use strict';

angular.module('studentRegistryApp').factory('StudentService', ['$http', function($http){

    var REST_SERVICE_URI = '/TestTwo/';

    var factory = {
        fetchAllStudents: fetchAllStudents,
    	createStudent: createStudent,
        updateStudent: updateStudent,
        deleteStudent: deleteStudent,
        editStudent: editStudent
        
    };
    return factory;

    function fetchAllStudents() {
       return $http.get(REST_SERVICE_URI+'getAllStudents');
    }

    function createStudent(student) {
        return $http.post(REST_SERVICE_URI+'studentRegistry/createStudent', student);
    }

    function updateStudent(selectedStudent, id) {
        return $http.put(REST_SERVICE_URI+'studentRegistry/updateStudent'+id, selectedStudent);
    }
    
    function deleteStudent(id) {
        return $http.delete(REST_SERVICE_URI+'studentRegistry/deleteStudent'+id); 
    }
    
    function editStudent(id) {
        return $http.put(REST_SERVICE_URI+'studentRegistry/editAStudent'+id);
    }
    
}]);
