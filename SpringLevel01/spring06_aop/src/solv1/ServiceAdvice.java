package solv1;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * 부수적인 기능을 모아놓은 어드바이스
 * 
 * 어드바이스를 만드는 방법
 * 1. api를 상속해서 작성
 * 	 1) XML 사용
 *   2) XML 사용하지 않음
 *   
 * 
 * 2. POJO로 작성
 * ::
 * 
 * 1 - 2)
 * ::
 * lib 추가
 * MethodInterceptor
 * Around방식의 어드바이스
 */
public class ServiceAdvice implements MethodInterceptor{
	private Log log = LogFactory.getLog(getClass());
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info("check....before....log");
		
		Object obj = invocation.proceed();
		System.out.println("obj :: "+obj);
		
		log.info("check...after...log");
		return obj;
	}
}





