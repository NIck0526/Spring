package api4;
/*
 * pojo 기반으로 작성
 * 이때 Around방식으로 돌아가도록....method인자값에 ProceedingJoinPpoint를 넣는다
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

// aop설정 부분을 xml에서 통으로 가져옴
@Aspect
public class LoggingAdvice{
	
	@Around("execution(* api4.Message*.say*(..))")
//aop
	
	public void timeLog(ProceedingJoinPoint pjp) throws Throwable { //ProceedingJoinPoint :: Around방식용
		String methodName = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD :"+ methodName+" is calling...");
		Object rtnObj = pjp.proceed();
		sw.stop();
		
		System.out.println("[LOG] METHOD :"+ methodName + " was called...");
		System.out.println("[LOG] 처리시간 : "+ sw.getTotalTimeMillis()/1000+ "초");
		
	}

}









