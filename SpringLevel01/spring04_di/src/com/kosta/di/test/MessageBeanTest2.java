package com.kosta.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kosta.di.MessageBean;
import com.kosta.di.Outputter;

public class MessageBeanTest2 {

	public static void main(String[] args) {
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("test/msg2.xml");
		System.out.println("1. 공장생성!!!");
		
		System.out.println("2.공장에서 빈을 가져옴");
		
		MessageBean  bean = factory.getBean("msg",MessageBean.class);
		
		System.out.println("3. 빈의 메소드를 호출...");
		
		bean.sayHello();
		//추가
		System.out.println("===============================================");
		Outputter output = (Outputter)factory.getBean("output");
		
		System.out.println("파일로 출력 성공!!");
		output.output("방가방가");
	}
}
