package solv2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * POJO | XML 사용 (aop 스키마 사용)
 */
public class ServiceAdvice {
	private Log log = LogFactory.getLog(getClass());
	
	//메소드의 인자값이 어드바이스의 유형을 결정한다.
	public void logPush(ProceedingJoinPoint pjp)throws Throwable { // target 의 특정 지점으로 Weaving 되어질 것이다.
		log.info("check.....before...");
		pjp.proceed(); //target이 실행
		log.info("check.....after....");
	}
}
