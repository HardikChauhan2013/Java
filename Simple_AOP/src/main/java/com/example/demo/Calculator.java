package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public void add() throws Exception {

		System.out.println("Calculator->Add");

		//throw new Exception();

	}
	
	
	public void divisioin() throws Exception {

		System.out.println("Calculator->divisioin");

		//throw new Exception();

	}

}
