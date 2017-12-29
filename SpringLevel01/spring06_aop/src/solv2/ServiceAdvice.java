package solv2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * POJO | XML ��� (aop ��Ű�� ���)
 */
public class ServiceAdvice {
	private Log log = LogFactory.getLog(getClass());
	
	//�޼ҵ��� ���ڰ��� �����̽��� ������ �����Ѵ�.
	public void logPush(ProceedingJoinPoint pjp)throws Throwable { // target �� Ư�� �������� Weaving �Ǿ��� ���̴�.
		log.info("check.....before...");
		pjp.proceed(); //target�� ����
		log.info("check.....after....");
	}
}
