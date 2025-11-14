package com.example.demo.form;

import java.util.Objects;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class RegisterForm {
	
	@NotBlank(message = "ユーザー名を入力してください。")
    @Size(min = 3, max = 10, message = "ユーザー名は3〜10文字で入力してください。")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "ユーザー名は半角英数字のみ使用できます。")
	private String usernameInput;
	
	@NotBlank(message = "パスワードを入力してください。")
    @Size(min = 8, max = 20, message = "パスワードは8〜20文字で入力してください。")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@;:])[a-zA-Z\\d!@;:]{8,20}$",
    message = "英字、数字、記号(!@;:)をそれぞれ1文字以上含めてください。英字、数字、記号（!@;:）以外の文字は使用できません。")

	private String passwordInput;
	
	@NotBlank(message = "パスワード（確認用）を入力してください。")
	@Size(min = 8, max = 20, message = "パスワードは8〜20文字で入力してください。")
	private String confirmPasswordInput;
	
	@AssertTrue(message = "パスワードが一致しません。")
	public  boolean isPasswordMatch() {
		return Objects.equals(passwordInput, confirmPasswordInput);
	}

}
