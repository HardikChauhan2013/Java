package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogUtil_PointCut {

	//where
	//within - package
	//this - class
	//execution - method 
	//args - args
	@Pointcut("execution(public void add())")
	public void pointCut_add() {}
	
	//@Pointcut("within(com.example.demo.*)") // . same pack 
	@Pointcut("within(com.example.demo..*)") // ..same pack - sub pack 
	public void pointCut_for_package() {}
	
	
	@Pointcut("within(com.example.demo.repostiry..*)") // ..same pack - sub pack 
	public void pointCut_for_Reportory() {}
	
	@Around("pointCut_for_Reportory()")
	public void logTimeExecute(JoinPoint jp) {
		
	}
	
	@Pointcut("this(com.example.demo.Calculator)") // for class name Calculator
	public void pointCut_for_class() {}
	
	//@Before("execution(public void add())")
	//@Before("pointCut_for_package() && pointCut_add()")
	@Before("pointCut_for_package() && pointCut_for_class() && pointCut_add()")
	public void LogInfo() {
		System.out.println("LogInfo - before");
	}
	
	@Before("pointCut_for_package() && pointCut_for_class()")
	public void LogInfo_class_any_method(JoinPoint jp) {
		System.out.println("LogInfo - before - class any method");
		System.out.println(jp.getSignature().getName());
		System.out.println(jp.getArgs());
	}
	
	//@After("execution(public void add())")
	@After("pointCut_add()")
	public void LogInfo_After() {
		System.out.println("LogInfo - after");
	}
	
	@AfterReturning("pointCut_add()")
	public void LogInfo_Sucess() {
		System.out.println("LogInfo - after - LogInfo_Sucess");
	}
	
	@AfterThrowing("pointCut_add()")
	public void LogInfo_Error() {
		System.out.println("LogInfo - after - Error");
	}
}
