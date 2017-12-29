package com.kosta.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kosta.di.MessageBean;

public class MessageBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("resources/messageBean.xml");
		System.out.println("1. �������!!!");
		
		System.out.println("2.���忡�� ���� ������");
		
		MessageBean  bean = factory.getBean("message2", MessageBean.class);
		
		System.out.println("3. ���� �޼ҵ带 ȣ��..."+bean.sayHello());
	}
}
