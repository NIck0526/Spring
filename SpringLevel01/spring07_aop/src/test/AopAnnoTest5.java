package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import api5.Dao;


public class AopAnnoTest5 {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("anno5.xml");
	//proxy��� �̸����� ȹ���� ���� �츮�� �˰� �ִ� target�� �ƴ�,
	//�̹� ProxyFactoryBean���� ȹ���� pfTarget�̶�� ����� ��������
	//�ٽø��ؼ�, �����̽��� ��� �ۼ��ߴ������� ���������δ� Proxy~~ �� ���ư���.
			Dao bean=(Dao)factory.getBean("target");
			bean.register();
	}
}











