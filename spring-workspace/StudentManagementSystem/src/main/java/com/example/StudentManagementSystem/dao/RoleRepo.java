package com.example.StudentManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagementSystem.entity.Role;



@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

	Role findByUserName(String userName);

//	Role findByRoleId(Integer roleId);
	
}