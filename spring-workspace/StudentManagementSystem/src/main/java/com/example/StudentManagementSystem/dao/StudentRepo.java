package com.example.StudentManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagementSystem.entity.Student;

/*
 *No need to add @Repository annotation, becz Jpa Repositoty has SimpleJpaRepository implementation
 *which has this annotation
 */
//<Student, Integer>: type of JPA Entity and type of parameter
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	
}
