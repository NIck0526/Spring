package com.kosta.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kosta.di.MessageBean;
import com.kosta.di.Outputter;

public class MessageBeanTest2 {

	public static void main(String[] args) {
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("test/msg2.xml");
		System.out.println("1. �������!!!");
		
		System.out.println("2.���忡�� ���� ������");
		
		MessageBean  bean = factory.getBean("msg",MessageBean.class);
		
		System.out.println("3. ���� �޼ҵ带 ȣ��...");
		
		bean.sayHello();
		//�߰�
		System.out.println("===============================================");
		Outputter output = (Outputter)factory.getBean("output");
		
		System.out.println("���Ϸ� ��� ����!!");
		output.output("�氡�氡");
	}
}
