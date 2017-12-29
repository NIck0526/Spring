package api2;
/*
 * advice유형 ::
 * 1) api를 상속 --- MethodInterceptor :: arround 방식의 어드바이스
 * 2) xml사용함 --- aop 스키마가 빠져있다....only 빈 설정으로만 xml을 작성하는 번거로움
 * 3) pointcut의 패턴으로 JDK 정규식 표현법을 사용.
 */
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice  implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD :"+ methodName+" is calling...");
		Object rtnObj = invocation.proceed();
		
		sw.stop();
		
		System.out.println("[LOG] METHOD :"+ methodName + " was called...");
		System.out.println("[LOG 처리시간 : "+ sw.getTotalTimeMillis()/1000+ "초");
		return rtnObj;
	}

}









