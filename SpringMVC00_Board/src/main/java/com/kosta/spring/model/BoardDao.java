package com.kosta.spring.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int write(BoardVO bvo)throws SQLException{
		return sqlSession.insert("boardMapper.write",bvo);
	}
	//selectByNoForDate
	public String selectByNoForDate(int no) throws SQLException{
			
		return sqlSession.selectOne("boardMapper.selectByNoForDate", no);
		//가져온다 날짜를 
	}
	public List<BoardVO> findAll() {
		
		return sqlSession.selectList("boardMapper.findAll");
	}
	
}