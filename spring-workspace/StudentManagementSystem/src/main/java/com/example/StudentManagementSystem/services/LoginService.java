package com.example.StudentManagementSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.dao.RoleRepo;
import com.example.StudentManagementSystem.entity.Role;

@Service
public class LoginService {

	@Autowired RoleRepo roleRepo;
	
//	public Role role(String userName, String passWord, Integer roleId) {
//		Role user = roleRepo.findByRoleId(roleId);
//		
//		return user;
//		
//	}


}
