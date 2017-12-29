package api5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/*
 * pojo
 * aop 스키마 사용
 * aspect-j 표현식 사용
 * around 방식
 */

//pojo

@Aspect // aop 스키마 사용
public class TimeAdvice {

	@Around("execution(* api5.Dao*.re*(..))") //  around 방식 && aspect-j 표현식 사용
	public void time(ProceedingJoinPoint pjp)throws Throwable{
		long start = System.currentTimeMillis();
		String targetMName = pjp.getSignature().getName();
		System.out.println(targetMName+" method start 시각 :: "+start);
		
		Object obj = pjp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(targetMName+" method End 시각 :: "+end);
		
		System.out.println(" 총 소요시각 :: "+(end-start)/1000+" 초");
	}
}






