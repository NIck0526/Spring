package com.kosta.service.impl;
/*
 * 后 汲沥巩辑
 * ::
 * 1. bean id	class="FQCN"
 * 2. 蔼 林涝 ------ 鞘靛
 * 		1) 积己磊
 * 		2) setter 
 */
import com.kosta.service.MemberService;

public class MemberServiceImpl implements MemberService{
	private int no; //积己磊
	private String name; //setter
	private Integer date; //setter
	
	@Override
	public String msg() {
		
		return name+" 救川!! "+date+" "+no;
	}

	public MemberServiceImpl(int no) {
		super();
		this.no = no;
		System.out.println("后 积己....!");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public MemberServiceImpl() {
		System.out.println("后 积己....!");
	}
	
}
