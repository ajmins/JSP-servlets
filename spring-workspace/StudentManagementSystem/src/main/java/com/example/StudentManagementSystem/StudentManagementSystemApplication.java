package com.example.StudentManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.StudentManagementSystem.dao.RoleRepo;
import com.example.StudentManagementSystem.dao.StudentRepo;
import com.example.StudentManagementSystem.entity.Role;
import com.example.StudentManagementSystem.entity.Student;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public void run(String... args) throws Exception {
		//Student std1 = new Student("Ajmi", "Siraj", "ajmi@gmail.com");
		//studentRepo.save(std1);
//		Role admin = new Role("admin", "admin123", 1);
//		roleRepo.save(admin);
//		Role user1 = new Role("student", "student123", 2);
//		roleRepo.save(user1);
//		Role user2 = new Role("teacher", "teacher123", 3);
//		roleRepo.save(user2);

		
	}

}
