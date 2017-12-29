package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import api4.MessageBean;

public class AopAnnoTest4 {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("anno4.xml");
	//proxy��� �̸����� ȹ���� ���� �츮�� �˰� �ִ� target�� �ƴ�,
	//�̹� ProxyFactoryBean���� ȹ���� pfTarget�̶�� ����� ��������
	//�ٽø��ؼ�, �����̽��� ��� �ۼ��ߴ������� ���������δ� Proxy~~ �� ���ư���.
			MessageBean bean=(MessageBean)factory.getBean("target");
			bean.sayHello();
	}
}











