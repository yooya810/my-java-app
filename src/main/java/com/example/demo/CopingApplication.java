package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CopingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CopingApplication.class, args);
		
		//.getBean(CopingApplication.class).exe();
	}
	/*
	private final CopingService service;
	
	public void exe() {

		System.out.println("SELECT BY ID");
		System.out.println(service.findAllByUserId(1));
		
		/**insert文
		CopingStrategy coping = new CopingStrategy();
		coping.setUser_id(1);
		coping.setTitle("カレーを食べる");
		coping.setDescription("カレーを食べて体力回復");
		coping.setCategory("かなしいとき");
		service.insertCopingStrategy(coping);
		System.out.println(service.findAllByUserId(1));
	
	/**update文
		CopingStrategy target = service.findByCopingId(1,1);
		target.setTitle("test");
		target.setDescription("test");
		service.updateCopingStrategy(target);
		
		System.out.println(service.findByCopingId(1,1));
	
	/**delete文
		service.deleteCopingStrategy(1);
		System.out.println(service.findAllByUserId(1));
	}
	
	*/
}

