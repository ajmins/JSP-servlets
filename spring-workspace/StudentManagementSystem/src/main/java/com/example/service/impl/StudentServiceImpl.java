package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.StudentRepo;
import com.example.entity.Student;
import com.example.service.StudentService;

@Service //implies this is a service class
//impl pakages are used for implementation classes
public class StudentServiceImpl implements StudentService{

	//dependency injection
	private StudentRepo studentRepo;
	
	//create constructor
	public StudentServiceImpl(com.example.dao.StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}
	
	@Override
	public List<Student> getAllStudents() {
		
		//returns list of students
		return studentRepo.findAll();
	}

	

}
