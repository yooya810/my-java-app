package com.example.demo.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.RegisterService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
	
	private final UserMapper mapper;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void registerUser(User user) {
		String rawPassword = user.getPass();
		String hashedPassword= passwordEncoder.encode(rawPassword);
		user.setPass(hashedPassword);
		mapper.insertUser(user);
	}
	
	@Override
	public User findByUsername(String username) {
		User user = mapper.selectByUsername(username);
		return user;
	}

}
