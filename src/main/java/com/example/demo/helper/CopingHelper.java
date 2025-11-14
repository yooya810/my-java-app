package com.example.demo.helper;

import com.example.demo.entity.CopingStrategy;
import com.example.demo.form.CopingForm;

public class CopingHelper {
	
	//Entityへの変換
	public static CopingStrategy convertCopingStrategy(CopingForm form) {
		CopingStrategy copingStrategy = new CopingStrategy();
		copingStrategy.setUser_id(form.getUser_id());
		copingStrategy.setCoping_id(form.getCoping_id());
		copingStrategy.setTitle(form.getTitle());
		copingStrategy.setDescription(form.getDescription());
		copingStrategy.setCategory(form.getCategory());
		copingStrategy.setExecution_count(form.getExecution_count());
		copingStrategy.setCreated_at(form.getCreated_at());
		copingStrategy.setUpdated_at(form.getUpdated_at());
		copingStrategy.setExecutionRecords(form.getExecutionRecords());
		
		return copingStrategy;
	}
	
	//Formへの変換
	public static CopingForm convertCopingForm(CopingStrategy copingStrategy) {
		CopingForm form = new CopingForm();
		form.setUser_id(copingStrategy.getUser_id());
		form.setCoping_id(copingStrategy.getCoping_id());
		form.setTitle(copingStrategy.getTitle());
		form.setDescription(copingStrategy.getDescription());
		form.setCategory(copingStrategy.getCategory());
		form.setExecution_count(copingStrategy.getExecution_count());
		form.setCreated_at(copingStrategy.getCreated_at());
		form.setUpdated_at(copingStrategy.getUpdated_at());
		form.setExecutionRecords(copingStrategy.getExecutionRecords());
		
		return form;
	}
}
