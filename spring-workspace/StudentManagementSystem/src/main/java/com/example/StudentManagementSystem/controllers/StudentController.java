package com.example.StudentManagementSystem.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentManagementSystem.dao.StudentRepo;
import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.services.StudentService;

//to make this class as spring mvc class to handle the requests
@Controller
public class StudentController {

//	private StudentService studentService;
//	//uses a constructor based dependency so create a constructor
//
//	public StudentController(StudentService studentService) {
//		super();
//		this.studentService = studentService;
//	}
	@Autowired
	private StudentRepo studentRepo;
	
//	@Autowired
//	StudentService studentService;
	//handler method to handle list of students and return model and view
	
	
	@GetMapping("/home")
	public String HomePage(@ModelAttribute("fa")String userName, Model model,HttpSession session) {
		model.addAttribute("fa",userName);
		System.out.println(userName);
		String username = (String) session.getAttribute("username");
		model.addAttribute("userName", username);
		return "home";
	}
	
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("studentsList",studentRepo.findAll());
		return "students"; //return a view named students
		}
		//whenever we add thymeleaf dependency springboot will automatically
		//configure a view resolver for thymeleaf whenever it saw dependency in pom file
		//no need to configure it
		//springboot also find all the thymleaf views under templates folder
		//so add this view inside template folder, that is an html file
//	public ModelAndView listStudents() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("students", studentService.getAllStudents());
//		
//		return mav;
//	}
	@GetMapping("/saveStudentPage")
	public String saveStudentPage(Model model) {
//		ModelAndView mav = new ModelAndView();
		Student student = new Student();
		model.addAttribute("students", student);
		return "addStudent";
	}
	@PostMapping("/saveStudent")
	//@ModelAttribute is like  
	public String  saveStudent(@ModelAttribute("students")Student student) { 
		studentRepo.save(student);
		return "redirect:/home"; //redirect to home page
		
	}
	@GetMapping("/editStudentPage/{id}")
	public String editStudent(@PathVariable("id")int id, Model model) {
		//check id found in db
		Optional<Student> tempId = studentRepo.findById(id);
		Student student = tempId.get();
		model.addAttribute("students", student);
		return "updateStudent";
	}
	
	@GetMapping("/deleteStudentPage/{id}")
	public String deleteStudent(@PathVariable("id")int id) {
		studentRepo.deleteById(id);
		return "redirect:/home";
	}
	
	
}
