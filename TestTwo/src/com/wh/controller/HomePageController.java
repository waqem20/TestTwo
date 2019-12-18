package com.wh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	@RequestMapping(value = "/studentRegistry", method = RequestMethod.GET)
	public String studentRegistryPage() {
		return "studentRegistry";

	}

}
