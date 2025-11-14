package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CopingStrategy {
	private Integer coping_id;
	private Integer  user_id;
	private String title;
	private String description;
	private String category;
	private int execution_count;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private List<ExecutionRecord> executionRecords;
}
