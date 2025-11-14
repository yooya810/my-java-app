package com.example.demo.service.impl;

import java.util.Objects;

import jakarta.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginUser;
import com.example.demo.service.UserSessionService;

@Service
public class UserSessionServiceImpl implements UserSessionService {

	@Override
	public void ensureUserSession(HttpSession session) {
		// セッションからユーザーIDを取得、なければ認証から取得
	    Integer userId = (Integer) session.getAttribute("userId");
	    String userName = (String) session.getAttribute("userName");

		if (userId == null) {
	        // 認証コンテキストから情報を取得
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        
	        // nullチェックと型安全性の確保
	        if (authentication != null && authentication.getPrincipal() instanceof LoginUser) {
	            LoginUser user = (LoginUser) authentication.getPrincipal();
	            userId = user.getUser_id();
	            userName = user.getUsername();

	            // セッションに安全に保存
	            session.setAttribute("userId", userId);
	            session.setAttribute("userName", userName);
	        } else {
	            // 認証エラー時の適切な処理
	            return;
	        }
	    }
	}
	
	@Override
	public boolean isAuthorizedUser(HttpSession session,Integer userId) {
		
		this.ensureUserSession(session);
		Integer sessionUserId =(Integer)session.getAttribute("userId");
		if(Objects.nonNull(sessionUserId) && Objects.equals(sessionUserId,userId)) {
			return true;
		}
		
		return false;
	}

}
