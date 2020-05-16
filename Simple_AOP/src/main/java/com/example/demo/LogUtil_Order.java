package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
@Order(1)
public class LogUtil_Order {

	@Before("execution(public void add())")
	public void LogInfo() {
		System.out.println("LogInfo - before");
	}
	
}

//@Component
//@Aspect
@Order(0)
class LogUtil_1 {

	@Before("execution(public void add())")
	public void Caching() {
		System.out.println("Caching - before");
	}
} 