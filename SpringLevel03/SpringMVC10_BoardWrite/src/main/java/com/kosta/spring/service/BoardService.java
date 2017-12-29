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
	
	//getBoardList
	public ListVO getBoardList(String pageNo)throws SQLException{
		if(pageNo==null || pageNo=="") {// 특정한 페이지를 클릭하지 않고 바로 최신 페이지로 들어가는 경우
			pageNo="1";
		}
		//return boardDao.getBoardList(pageNo);
		
		
		// +++++++++++++++ 페이징 ㅓ리시 수정되어야 하는 부분 +++++++++++++++
		List<BoardVO> list = boardDao.getBoardList(pageNo); //현재 페이지에 대한 list
		int totalCount = boardDao.totalCount();
		
		PagingBean paging = new PagingBean(totalCount, Integer.parseInt(pageNo));
		ListVO lvo = new ListVO(list, paging);
		return lvo;
		
	}
	
	//showContent
	public BoardVO showContent(String no) throws SQLException{
		
		return boardDao.showContent(no);
	}
	
	//delete
	public void delete(String no) throws SQLException{
		
		boardDao.delete(no);
	}
	
	public void updateCount(String no) throws SQLException{
		boardDao.updateCount(no);
	}
	
	//update
	public void update(BoardVO vo) throws SQLException{
		
		 boardDao.update(vo);
	}
	
}














