package com.wh.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wh.manager.StudentManager;
import com.wh.view.StudentView;

@Controller
public class StudentController {

	@Autowired
	private StudentManager studentManager;

	@RequestMapping(value = "/getAllStudents")
	public ResponseEntity<List<StudentView>> getAllStudents() {
		return new ResponseEntity<>(studentManager.findAllStudent(), HttpStatus.OK);
	}

	@RequestMapping(value = "/studentRegistry/createStudent", method = RequestMethod.POST)
	public ResponseEntity<StudentView> createStudent(@RequestBody StudentView createStudent) {

		if (createStudent == null) {
			Logger.getLogger("Error while creating a student.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		studentManager.saveStudent(createStudent);
		return new ResponseEntity<>(createStudent, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/studentRegistry/updateStudent{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudentView> updateStudent(@RequestBody StudentView currentStudent) {

		if (currentStudent == null) {
			Logger.getLogger("Error while updating a student.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		Logger.getLogger("update student:" + currentStudent);
		studentManager.updateStudent(currentStudent);
		return new ResponseEntity<>(currentStudent, HttpStatus.OK);
	}

	@RequestMapping(value = "/studentRegistry/deleteStudent{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentView> deleteStudent(@PathVariable("id") Long id) {
		studentManager.deleteStudentById(id);
		Logger.getLogger("deleted student with the id of :" + id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
