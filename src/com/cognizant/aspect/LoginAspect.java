package com.cognizant.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.cognizant.service.ApplyHomeLoanService;

@Aspect
@Component
public class LoginAspect {
	private static final Logger LOG = Logger.getLogger(ApplyHomeLoanService.class);

	@Before("execution(* com.cognizant.service..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		LOG.info("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature());
       System.out.println("Before running loggingAdvice on method="+joinPoint.toString());
		
		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));
		System.out.println("******");
	}
	@AfterReturning(pointcut="execution(* com.cognizant.service..*(..))",returning="result")
	public void logBefore1(JoinPoint joinPoint,Object result) {
		LOG.info("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature());
       System.out.println("Before running loggingAdvice on method="+joinPoint.toString());
		
		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));
		System.out.println("******");
		System.out.println("Metod returns  "+result.toString());
	}
}
