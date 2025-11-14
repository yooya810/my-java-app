package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	/** ユーザーID */
	private Integer user_id;
	/** ユーザー名 */
	private String user_name;
	/** パスワード */
	private String pass;
	/** メールアドレス（未実装） */
	private String mail;
}
