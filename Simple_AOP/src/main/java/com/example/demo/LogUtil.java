package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class LogUtil {

	@Before("execution(public void add())")
	public void LogInfo() {
		System.out.println("LogInfo - before");
	}
	
	@After("execution(public void add())")
	public void LogInfo_After() {
		System.out.println("LogInfo - after");
	}
	
	@AfterReturning("execution(public void add())")
	public void LogInfo_Sucess() {
		System.out.println("LogInfo - after - LogInfo_Sucess");
	}
	
	@AfterThrowing("execution(public void add())")
	public void LogInfo_Error() {
		System.out.println("LogInfo - after - Error");
	}
}
