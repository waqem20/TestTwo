package com.wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wh.manager.StudentManager;
import com.wh.view.StudentView;

@Controller
public class StudentAddController {

	@Autowired
	private StudentManager studentManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landing() {
		return "landing";
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student() {
		return "student";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("addStudent") StudentView student) {
		studentManager.saveStudent(student);
		return new ModelAndView("result");
	}

}
