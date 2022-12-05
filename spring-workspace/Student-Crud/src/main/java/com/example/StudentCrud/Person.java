package com.example.StudentCrud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	@Column(name = "PID")
	private Integer personId;
	
	@Column(name = "NAME")
	private String personName;
	
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}


	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + "]";
	}
	

	
	
	
}
