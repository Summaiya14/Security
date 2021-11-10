package com.example.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.models.Role;
import com.example.security.models.User;
import com.example.security.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return ResponseEntity.ok(userService.saveUser(user));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		return ResponseEntity.ok(userService.saveRole(role));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/role/addtouser")
	public ResponseEntity<Role> addRoleToUser(@RequestBody RoleToUserForm form){
		userService.addRoleToUser(form.getUserName(), form.getRoleName());
		return ResponseEntity.ok().build();
	}
	
}

class RoleToUserForm {
	private String userName;
	private String roleName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
