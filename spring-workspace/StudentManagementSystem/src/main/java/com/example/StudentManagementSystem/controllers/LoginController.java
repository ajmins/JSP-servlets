package com.example.StudentManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.StudentManagementSystem.dao.RoleRepo;
import com.example.StudentManagementSystem.dao.StudentRepo;

@Controller
public class LoginController {

	@Autowired
	private RoleRepo roleRepo;
	
	@GetMapping("/")
	public String HomePage() {
		return "login";
	}
	
	
	
	
	
	
}
