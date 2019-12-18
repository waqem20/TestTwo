package com.wh.service;

import java.util.List;

import com.wh.entity.Student;

public interface StudentService {

	void saveStudent(Student student);

	void updateStudent(Student student);

	List<Student> findAllStudent();

	void deleteStudentById(Long id);

}
