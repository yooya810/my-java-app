package com.example.demo.service;

import jakarta.servlet.http.HttpSession;

public interface UserSessionService {
	
	public void ensureUserSession(HttpSession session);
	
	public boolean isAuthorizedUser(HttpSession session,Integer userId);

}
