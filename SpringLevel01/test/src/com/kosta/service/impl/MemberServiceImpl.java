package com.kosta.service.impl;
/*
 * �� ��������
 * ::
 * 1. bean id	class="FQCN"
 * 2. �� ���� ------ �ʵ�
 * 		1) ������
 * 		2) setter 
 */
import com.kosta.service.MemberService;

public class MemberServiceImpl implements MemberService{
	private int no; //������
	private String name; //setter
	private Integer date; //setter
	
	@Override
	public String msg() {
		
		return name+" �ȴ�!! "+date+" "+no;
	}

	public MemberServiceImpl(int no) {
		super();
		this.no = no;
		System.out.println("�� ����....!");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public MemberServiceImpl() {
		System.out.println("�� ����....!");
	}
	
}
