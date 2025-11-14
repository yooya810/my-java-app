package com.example.demo.service;

import com.example.demo.entity.User;

public interface RegisterService {
	
	public void registerUser(User user);
	
	public User findByUsername(String username);
	

}
