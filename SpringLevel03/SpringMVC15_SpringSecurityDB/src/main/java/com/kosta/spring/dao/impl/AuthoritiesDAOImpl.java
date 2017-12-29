package com.kosta.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.spring.dao.AuthoritiesDAO;
import com.kosta.spring.vo.Authority;
@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
		
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<Authority> selectAuthorityByUserName(String username) {
		
		return sqlSession.selectList("authoritiesMapper.selectAuthorityByUserName",username);
	}

	@Override
	public int insertAuthority(Authority authority) {
		
		return sqlSession.insert("authoritiesMapper.insertAuthority", authority);
	}

	
}
