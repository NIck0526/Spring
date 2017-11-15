package com.kosta.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.spring.model.BoardDao;
import com.kosta.spring.model.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public void write(BoardVO bvo)throws SQLException{
		System.out.println("Before BVO :: "+bvo.getNo()); //0
		boardDao.write(bvo); //selectKey가 돌아가서 시퀀스를 vo에주입
		System.out.println("After BVO :: "+bvo.getNo()); //3
		
		String date=boardDao.selectByNoForDate(bvo.getNo());//3
		//DAO에서 받아온 날짜를 bvo에 다시 세팅해준다...
		bvo.setWriteDate(date);
	}
	
	public List<BoardVO> findAll() throws SQLException{
		
		return boardDao.findAll();
	}
}
