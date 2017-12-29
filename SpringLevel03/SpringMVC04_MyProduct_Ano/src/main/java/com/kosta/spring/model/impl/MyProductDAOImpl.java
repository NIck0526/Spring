package com.kosta.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.spring.model.MyProductDAO;
import com.kosta.spring.model.MyProductVO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insertMyProduct(MyProductVO vo) {
		
		int result = sqlSession.insert("myProductMapper.insertMyProduct",vo);
		
		System.out.println("INSERT PRODUCT...OK..."+result+" ROW!!");
		return result;
	}

	@Override
	public List<MyProductVO> findByProductName(String name) {
		List<MyProductVO> list = sqlSession.selectList("myProductMapper.findByProductName", name);
		return list;
	}

	@Override
	public List<MyProductVO> findByMaker(String name) {
		
		return sqlSession.selectList("myProductMapper.findByMaekr", name);
	}

}
