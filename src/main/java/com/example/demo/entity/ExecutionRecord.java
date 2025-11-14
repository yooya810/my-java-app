package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionRecord {
	private Integer execution_id;
	private Integer coping_id;
	private LocalDateTime execution_time;
	private Integer count;
}
