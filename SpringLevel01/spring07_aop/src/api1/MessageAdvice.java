package api1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
 * Cross Cutting Concern 이 들어있는 어드바이스 클래스
 * target class 의 비지니스 로직이 호출되면
 * 이걸 인터셉터인 MessageAdvice가 이벤트로 감지해서
 * invoke()가 호출 된다.
 * 결국 비지니스 로직이 실행되기 전에 invoke()가 실행된다.
 * 
 */
public class MessageAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//비지니스 로직 실행 전 수행되는 로직..Before
		System.out.println("1.비지니스 로직 실행 전 수행되는 로직...");
		
		Object obj = invocation.proceed(); //이때가 비지니스 로직이 호출
		if(obj!=null) {	// target클래스의 리턴 타입이 null이 아닌 로직
			System.out.println("target 의 리턴 값 :: "+obj);
		}
		
		
		//비지니스 로직 실행한 후 수행되는 로직...After
		System.out.println("2. 비지니스 로직 실행한 후 수행되는 로직...");
		return null;
	}
}
