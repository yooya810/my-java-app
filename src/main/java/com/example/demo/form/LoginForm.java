package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginForm {
	/**ユーザー名*/
	@NotBlank(message = "ユーザー名を入力してください。")
	@Size(min = 3, max = 10, message = "ユーザー名は3〜10文字で入力してください。")
	private String usernameInput;
	/**パスワード*/
	@NotBlank(message = "パスワードを入力してください。")
	@Size(min = 8, max = 20, message = "パスワードは8〜20文字で入力してください。")
	private String passwordInput;

}
