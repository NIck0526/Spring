package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import api2.MessageBean;

public class AopApiTest2 {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("api2.xml");
	//proxy��� �̸����� ȹ���� ���� �츮�� �˰� �ִ� target�� �ƴ�,
	//�̹� ProxyFactoryBean���� ȹ���� pfTarget�̶�� ����� ��������
	//�ٽø��ؼ�, �����̽��� ��� �ۼ��ߴ������� ���������δ� Proxy~~ �� ���ư���.
			MessageBean bean=(MessageBean)factory.getBean("proxy");
			bean.sayHello();
	}
}











