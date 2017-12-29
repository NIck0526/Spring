package api3;
/*
 * pojo 기반으로 작성
 * 이때 Around방식으로 돌아가도록....method인자값에 ProceedingJoinPpoint를 넣는다
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAdvice{
	
	
	public void timeLog(ProceedingJoinPoint pjp) throws Throwable { //ProceedingJoinPoint :: Around방식용
		String methodName = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD :"+ methodName+" is calling...");
		Object rtnObj = pjp.proceed();
		sw.stop();
		
		System.out.println("[LOG] METHOD :"+ methodName + " was called...");
		System.out.println("[LOG} 처리시간 : "+ sw.getTotalTimeMillis()/1000+ "초");
		
	}

}









