package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ToRun implements CommandLineRunner {

	@Autowired
	private Calculator cal;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("AOP Demo");
		
		cal.add();
		
		cal.divisioin();
	}

}
