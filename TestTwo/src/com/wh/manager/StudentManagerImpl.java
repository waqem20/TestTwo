package com.wh.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.entity.Student;
import com.wh.service.StudentService;
import com.wh.view.StudentView;

@Service
public class StudentManagerImpl implements StudentManager {

	@Autowired
	private StudentService studentService;

	@Override
	public void saveStudent(Student student) {
		studentService.saveStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentService.updateStudent(student);
	}

	@Override
	public List<StudentView> findAllStudent() {
		List<StudentView> studentView = new ArrayList<>();
		for (Student student : studentService.findAllStudent()) {
			StudentView view = new StudentView(student);
			studentView.add(view);
		}
		return studentView;
	}

	@Override
	public void deleteStudentById(Long id) {
		studentService.deleteStudentById(id);
	}

}