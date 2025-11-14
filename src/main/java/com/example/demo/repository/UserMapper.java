package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
	/**
	 * ユーザー名でログイン情報を取得します。
	 */
	
	User selectByUsername(String username);
	
	void insertUser(User user);
}
