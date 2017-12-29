package api3;
/*
 * pojo ������� �ۼ�
 * �̶� Around������� ���ư�����....method���ڰ��� ProceedingJoinPpoint�� �ִ´�
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAdvice{
	
	
	public void timeLog(ProceedingJoinPoint pjp) throws Throwable { //ProceedingJoinPoint :: Around��Ŀ�
		String methodName = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD :"+ methodName+" is calling...");
		Object rtnObj = pjp.proceed();
		sw.stop();
		
		System.out.println("[LOG] METHOD :"+ methodName + " was called...");
		System.out.println("[LOG} ó���ð� : "+ sw.getTotalTimeMillis()/1000+ "��");
		
	}

}









