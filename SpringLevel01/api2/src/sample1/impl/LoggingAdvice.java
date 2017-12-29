package sample1.impl;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice {
	public Object invoke(MethodInvocation invocation)throws Throwable{
		
		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD: "+methodName+"is calling.");
		Object rtnObj = invocation.proceed();
		
		sw.stop();
		
		System.out.println("[LOG] METHOD: "+methodName+"was called.");
		System.out.println("[LOG] ó���ð� :"+sw.getTotalTimeMillis()/1000+" ��");
		
		return rtnObj;
	}
}