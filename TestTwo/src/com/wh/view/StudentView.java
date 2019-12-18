package com.wh.view;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wh.entity.Student;

public class StudentView implements Student {

	private Integer id;

	private String name;

	private Integer age;

	private String email;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy", timezone = "CST")
	private Date date;

	public StudentView() {
		/*
		 * default constuctor
		 */
	}

	public StudentView(Integer id, String name, Integer age, String email, Date date) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.date = date;

	}

	public StudentView(Student student) {
		BeanUtils.copyProperties(student, this, StudentView.class);
	}

	@Override
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public Integer getAge() {
		return age;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Date getDate() {
		return date;
	}

}
