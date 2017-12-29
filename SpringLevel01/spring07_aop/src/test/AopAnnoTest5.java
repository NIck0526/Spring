package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import api5.Dao;


public class AopAnnoTest5 {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("anno5.xml");
	//proxy라는 이름으로 획득한 빈은 우리가 알고 있는 target이 아닌,
	//이미 ProxyFactoryBean에서 획득한 pfTarget이라는 사실을 잊지말자
	//다시말해서, 어드바이스를 어떻게 작성했던지간에 내부적으로는 Proxy~~ 로 돌아간다.
			Dao bean=(Dao)factory.getBean("target");
			bean.register();
	}
}











