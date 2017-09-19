package com.example.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class StudentLog {
	private static Logger logger=LoggerFactory.getLogger(StudentLog.class);
	
	@Pointcut("execution(public * com.example.controller.StudentController.*(..))")
	public void log(){	
		
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		//logger.info("开始执行");
		ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		//url
		logger.info("url={}", request.getRequestURL());
		//method
		logger.info("method={}",request.getMethod());
		//ip
		logger.info("ip={}",request.getRemoteAddr());
		//类方法
		logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//参数
		logger.info("args={}",joinPoint.getArgs());
	}
	
	@After("log()")
	public void doAfter(){
		logger.info("结束执行");
	}
	
	@AfterReturning(pointcut="log()",returning="object")
	public void afterReturn(Object object){
		logger.info("return={}",object);
	}
	
}
