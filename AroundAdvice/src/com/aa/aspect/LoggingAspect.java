package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public Object log(ProceedingJoinPoint pjp) throws Throwable{
		
		String methodName=pjp.getSignature().getName();
		Object[] args=pjp.getArgs();
		
		System.out.print("entering into "+methodName+"(");
		
		for(int i=0;i<args.length;i++){
			if(i==0){
				System.out.print(args[i]);
				continue;
			}
			System.out.print(","+args[i]);
		}
		System.out.println(")");
		
		Object ret=pjp.proceed();
		//Object ret=pjp.proceed(args);	//with modified args we want to call target class
		
		System.out.println("return value is "+ret);
		
		return ret;
	}
}
