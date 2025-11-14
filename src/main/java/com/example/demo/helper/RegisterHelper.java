package com.example.demo.helper;

import com.example.demo.entity.User;
import com.example.demo.form.RegisterForm;

public class RegisterHelper {
	
	//Entityへの変換
	public static User convertUser(RegisterForm form) {
		User user = new User();
		user.setUser_name(form.getUsernameInput());
		user.setPass(form.getPasswordInput());
		return user;
	}
	//Formへの変換
	public static RegisterForm convertRegisterForm(User user) {
		RegisterForm form = new RegisterForm();
		form.setUsernameInput(user.getUser_name());
		form.setPasswordInput(user.getPass());
		return form;
	}
}
