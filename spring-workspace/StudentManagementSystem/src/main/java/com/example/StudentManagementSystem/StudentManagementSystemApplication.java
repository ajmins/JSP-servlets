package com.example.StudentManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.StudentRepo;
import com.example.entity.Student;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

//	@Autowired
//	private StudentRepo studentRepo;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Student std1 = new Student("Ajmi", "Siraj", "ajmi@gmail.com");
//		studentRepo.save(std1);
//		
//	}

}
