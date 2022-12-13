package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//converting this java class as JPA entity
@Entity
@Table(name ="students")
public class Student {

	@Id //to define an identifier
	/*
	 *  to automatically generate the primary key value use @GeneratedValue annotation.
		This can use four generation types: AUTO, IDENTITY, SEQUENCE and TABLE.
		default value is AUTO.
	 */
	//expects values generated by an identity column in the database. 
	//This means they are auto-incremented.
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	//if we let Hibernate generate the database schema automatically, 
	//it applies the not null constraint to the particular database column.
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	
	//create default constructor also, becz hibernate internally use proxies to create 
	//objects dyamically & it needs a default constructor in JPA entity
	
	//parametrized constructor
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}


