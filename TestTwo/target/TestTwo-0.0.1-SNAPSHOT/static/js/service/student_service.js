'use strict';

angular.module('myApp').factory('StudentService', ['$http', function($http){

    var REST_SERVICE_URI = '/TestTwo/';

    var factory = {
        fetchAllStudents: fetchAllStudents,
    	createStudent: createStudent,
        updateStudent: updateStudent,
        deleteStudent: deleteStudent
        
    };
    return factory;

    function fetchAllStudents() {
       return $http.get(REST_SERVICE_URI+'getAllStudents');
    }

    function createStudent(student) {
        return $http.post(REST_SERVICE_URI+'student/', student);
    }

    function updateStudent(student, id) {
        return $http.put(REST_SERVICE_URI+'student/'+id, student);
    }
    
    function deleteStudent(id) {
        return $http.delete(REST_SERVICE_URI+'student/'+id); 
    }
    
}]);
