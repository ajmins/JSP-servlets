package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;

/*
 *No need to add @Repository annotation, becz Jpa Repositoty has SimpleJpaRepository implementation
 *which has this annotation
 */
//<Student, Long>: type of JPA Entity and type of parameter
public interface StudentRepo extends JpaRepository<Student, Long> {

	
}
