package com.kosta.di.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kosta.di.MessageBean;
import com.kosta.di.Outputter;

public class MessageBeanImpl implements MessageBean{
	private String name; // ������ ����(�ܼ� ������Ƽ�� ����)
	private String greeting; //setter ����
	
	//�߰�
	@Autowired
	private Outputter outputter;
	
	
	@Override
	public String sayHello() {
		System.out.println(name+" !!, "+greeting);
		return name+greeting ;
	}

	//�߰�
	/*public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}*/


	public MessageBeanImpl(String name) {
		super();
		this.name = name;
	}


	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}








