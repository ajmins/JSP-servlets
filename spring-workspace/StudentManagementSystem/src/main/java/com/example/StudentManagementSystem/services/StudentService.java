package com.example.StudentManagementSystem.services;
/*
 * 
 * Not using this layer
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.dao.StudentRepo;
import com.example.StudentManagementSystem.entity.Student;

@Service //implies this is a service class
//impl pakages are used for implementation classes
public class StudentService{

	//dependency injection
	@Autowired
	private StudentRepo studentRepo;
	
//	//create constructor
//	public StudentServiceImpl(com.example.StudentManagementSystem.dao.StudentRepo studentRepo) {
//		super();
//		this.studentRepo = studentRepo;
//	}
	
	public JSONArray getAllStudents() {
		
		//returns list of students
		System.out.println(studentRepo.findAll());
//		return studentRepo.findAll();
		List<Student>list = new ArrayList<Student>();
		list=studentRepo.findAll();
		JSONArray objArr = new JSONArray();
		for (Student student : list) {
			JSONObject obj = new JSONObject();
			obj.put("firstName", student.getFirstName());
			obj.put("lastName", student.getLastName());
			obj.put("email", student.getEmail());
			
			objArr.add(obj);
		}
		
		String obJsonArray = JSONArray.toJSONString(list);
		System.out.println(obJsonArray);
		return objArr;
	}

	

}
