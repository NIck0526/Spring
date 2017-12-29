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
	}	
	
	//getBoardList
	public List<BoardVO> getBoardList(String no)throws SQLException{
		return sqlSession.selectList("boardMapper.getBoardList", no);
	}	
	
	//showContent
	public BoardVO showContent(String no) throws SQLException{
		return sqlSession.selectOne("boardMapper.showContent",no);
	}
	
	//deleteBoard
	public void deleteBoard(String no) throws SQLException{
		sqlSession.delete("boardMapper.deleteBoard", no);
	}
	
	//updateCount
	public void updateCount(String no) throws SQLException{
		sqlSession.update("boardMapper.updateCount",no);
	}
	
	//updateBoard
	public void updateBoard(BoardVO vo) throws SQLException{
		sqlSession.update("boardMapper.updateBoard",vo);
	}
	
	//페이징 처리 추가
	public int totalCount() throws SQLException{
		return sqlSession.selectOne("boardMapper.totalCount");
	}
}




















