package com.logi4jpack;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * This class uses Spring AOP to centralize logging statements
 * @author varga
 *
 */
@Aspect
@Component // ("loggingAspect")
public class LogUtil {

	private Logger log = Logger.getLogger(getClass());
	
	//These logs will be performed before a method begins executing
	@Before("execution(* com.controllerpack.*.*(..))")
	public void logControllersBefore(JoinPoint point) {
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().toString();
		log.info("Attempting to run " + className + ": " + methodName);
	}
	
	@Before("execution(* com.repo.*.*(..))")
	public void logRepoBefore(JoinPoint point) {
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().toString();
		log.info("Attempting to run " + className + ": " + methodName);
	}
	
	@Before("execution(* com.servicepack.*.*(..))")
	public void logServiceBefore(JoinPoint point) {
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().toString();
		log.info("Attempting to run " + className + ": " + methodName);
	}
	
	// These logs will be performed after a method has executed
	@After("execution(* com.controllerpack.*.*(..))")
	public void logControllersAfter(JoinPoint point) {
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().toString();
		log.info(className + ": " + methodName + " ran successfully");
	}
	
	@After("execution(* com.repo.*.*(..))")
	public void logRepoAfter(JoinPoint point) {
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().toString();
		log.info(className + ": " + methodName + " ran successfully");
	}
	
	@After("execution(* com.servicepack.*.*(..))")
	public void logServiceAfter(JoinPoint point) {
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().toString();
		log.info(className + ": " + methodName + " ran successfully");
	}
	
//	@Around("execution(* com.controllerpack.LoginController.*(..))")
//	public void log(ProceedingJoinPoint point) throws Throwable {
//		// String methodName = point.getSignature().getName();
//		// Object[] arguments = point.getArgs();
//		 Users u = (Users) arguments[1];
//		Users u = (Users) point.proceed();
//		System.out.println(u);
//		if (u == null) {
//			log.info("User failed to login");
//		} else {
//			log.info(u.getUserName() + " logged in successfully");
//		}
//		point.proceed();
//	}
}
