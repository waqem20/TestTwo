package com.wh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wh.entity.Student;
import com.wh.entity.StudentImpl;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Student saveStudent(Student student) {
		getSession().persist(student);
		Criteria criteria = getSession().createCriteria(StudentImpl.class);
		criteria.add(Restrictions.idEq(student.getId()));
		return (Student) criteria.uniqueResult();
	}

	@Override
	public Student updateStudent(Student student) {
		getSession().update(student);
		Criteria criteria = getSession().createCriteria(StudentImpl.class);
		criteria.add(Restrictions.idEq(student.getId()));
		return (Student) criteria.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> findAllStudent() {
		Criteria criteria = getSession().createCriteria(StudentImpl.class);
		return criteria.list();
	}

	@Override
	public void deleteStudentById(Long id) {
		Query query = getSession().createSQLQuery("delete from Student where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}
}
