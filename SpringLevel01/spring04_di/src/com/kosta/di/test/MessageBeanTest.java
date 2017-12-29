package com.kosta.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kosta.di.MessageBean;

public class MessageBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("resources/messageBean.xml");
		System.out.println("1. 공장생성!!!");
		
		System.out.println("2.공장에서 빈을 가져옴");
		
		MessageBean  bean = factory.getBean("message2", MessageBean.class);
		
		System.out.println("3. 빈의 메소드를 호출..."+bean.sayHello());
	}
}
