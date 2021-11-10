package com.example.security.service;

import java.util.List;

import com.example.security.models.Role;
import com.example.security.models.User;

public interface UserService {

	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String userName, String roleName);
	User getUser(String userName);
	List<User>getUsers();
}
