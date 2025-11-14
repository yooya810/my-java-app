package com.example.demo.form;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.example.demo.entity.ExecutionRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CopingForm { 
	private Integer coping_id;
	private Integer  user_id; 
	@NotBlank(message = "タイトルは必須です")
	private String title;
	@Size(min = 0, max = 50, message="詳細は{min}～{max}文字以内で入力してください")
	private String description;
	@Size(min = 0,max = 10,message="カテゴリは{min}～{max}文字以内で入力してください")
	private String category;

	@Max(999)
	@Min(0)
	private Integer execution_count;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private List<ExecutionRecord> executionRecords;
}
