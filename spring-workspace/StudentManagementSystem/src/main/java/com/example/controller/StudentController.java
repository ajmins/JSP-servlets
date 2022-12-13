package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.StudentService;

//to make this class as spring mvc class to handle the requests
@Controller
public class StudentController {

	private StudentService studentService;
	//uses a constructor based dependency so create a constructor

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method to handle list of students and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("student",studentService.getAllStudents());
		return "students"; //return a view named students
		//whenever we add thymeleaf dependency springboot will automatically
		//configure a view resolver for thymeleaf whenever it saw dependency in pom file
		//no need to configure it
		//springboot also find all the thymleaf views under templates folder
		//so add this view inside template folder, that is an html file
		
	}
}
