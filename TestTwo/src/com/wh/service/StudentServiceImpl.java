package com.wh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wh.dao.StudentDao;
import com.wh.entity.Student;
import com.wh.entity.StudentImpl;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	@Transactional
	public void saveStudent(Student student) {
		StudentImpl studentImpl = new StudentImpl(student);
		studentDao.saveStudent(studentImpl);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		StudentImpl studentImpl = new StudentImpl(student);
		studentDao.updateStudent(studentImpl);
	}

	@Override
	@Transactional
	public List<Student> findAllStudent() {
		return studentDao.findAllStudent();
	}

	@Override
	@Transactional
	public void deleteStudentById(Long id) {
		studentDao.deleteStudentById(id);
	}

}
