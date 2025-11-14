package com.example.demo.service.impl;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginUser;
import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;

import lombok.RequiredArgsConstructor;

/**
 * カスタム認証サービス
 * UserDetailServiceを実装している。そのため、ログイン情報を入力した際の処理時に呼び出される。
 */
@Service
@RequiredArgsConstructor
public class LoginUserDatailsServiceImpl implements UserDetailsService {
	/** DI */
	private final UserMapper userMapper;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException{
		// 「ユーザーテーブル」からデータを取得
		User user = userMapper.selectByUsername(username);
		
		//対象データがあれば、UserDetailsの実装クラスを返す
		if(user != null) {
			//対象データが存在する
			//UserDetailsの実装クラスを返す
			return new LoginUser(
					user.getUser_id(),
					user.getUser_name(),
					user.getPass(),
					Collections.emptyList());
		}else {
			//対象データが存在しない
			throw new UsernameNotFoundException(
					username + "=>指定しているユーザー名は存在しません"
			);
		}
	}
}
