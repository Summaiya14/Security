package com.example.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.security.models.Role;
import com.example.security.models.User;
import com.example.security.repositories.RoleRepository;
import com.example.security.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		if(user == null) {
			System.out.println("User not found in the database");
			throw new UsernameNotFoundException("User not found in the database");
		} else {
			System.out.println("User found in the database");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			});
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		User user = userRepository.findByName(userName);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String userName) {
		return userRepository.findByName(userName);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	
}
