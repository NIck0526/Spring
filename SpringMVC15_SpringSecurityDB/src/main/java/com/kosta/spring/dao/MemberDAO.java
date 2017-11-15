package com.kosta.spring.dao;

import com.kosta.spring.vo.Member;

public interface MemberDAO {

	Member selectById(String id); 
	int insertMember(Member member);
	
	
}
