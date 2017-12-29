package api1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
 * Cross Cutting Concern �� ����ִ� �����̽� Ŭ����
 * target class �� �����Ͻ� ������ ȣ��Ǹ�
 * �̰� ���ͼ����� MessageAdvice�� �̺�Ʈ�� �����ؼ�
 * invoke()�� ȣ�� �ȴ�.
 * �ᱹ �����Ͻ� ������ ����Ǳ� ���� invoke()�� ����ȴ�.
 * 
 */
public class MessageAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//�����Ͻ� ���� ���� �� ����Ǵ� ����..Before
		System.out.println("1.�����Ͻ� ���� ���� �� ����Ǵ� ����...");
		
		Object obj = invocation.proceed(); //�̶��� �����Ͻ� ������ ȣ��
		if(obj!=null) {	// targetŬ������ ���� Ÿ���� null�� �ƴ� ����
			System.out.println("target �� ���� �� :: "+obj);
		}
		
		
		//�����Ͻ� ���� ������ �� ����Ǵ� ����...After
		System.out.println("2. �����Ͻ� ���� ������ �� ����Ǵ� ����...");
		return null;
	}
}
