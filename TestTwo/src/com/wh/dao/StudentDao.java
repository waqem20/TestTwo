package com.wh.dao;

import java.util.List;

import com.wh.entity.Student;

public interface StudentDao {

	Student saveStudent(Student student);

	Student updateStudent(Student student);

	List<Student> findAllStudent();

	void deleteStudentById(Long id);
}
