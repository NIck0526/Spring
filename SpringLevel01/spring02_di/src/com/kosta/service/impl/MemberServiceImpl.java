package com.kosta.service.impl;
/*
 * 빈 설정문서
 * ::
 * 1. bean id	class="FQCN"
 * 2. 값 주입 ------ 필드
 * 		1) 생성자
 * 		2) setter 
 */
import com.kosta.service.MemberService;

public class MemberServiceImpl implements MemberService{
	private int no; //생성자
	private String name; //setter
	private Integer date; //setter
	
	@Override
	public String msg() {
		
		return name+"안뇽!!"+date+""+no;
	}

	public MemberServiceImpl(int no) {
		super();
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Integer date) {
		this.date = date;
	}
	
}
