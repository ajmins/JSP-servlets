package com.example.StudentManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="role")
public class Role {

	@Id //to define an identifier
	@Column(name = "id")
	private Integer id;
	private String userName;
	private String passWord;
	private Integer roleId;
	
	//default 
	public Role() {
		
	}

	public Role(Integer id, String userName, String passWord, Integer roleId) {
		super();
		this.id = id;
		this.userName = userName;
		this.setPassWord(passWord);
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", roleId=" + roleId + "]";
	}
	
	
}
