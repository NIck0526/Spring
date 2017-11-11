package com.kosta.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.spring.model.BoardVO;
import com.kosta.spring.model.MemberVO;
import com.kosta.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response, BoardVO bvo) throws Exception{
		
		System.out.println("1. writeController...."+bvo);
		MemberVO mvo = (MemberVO)request.getSession().getAttribute("mvo"); // session에 바인딩된 로그인아이디(mvo)를 가져옴 
		if(mvo == null) return new ModelAndView("redirect:/index.jsp");
		
	
		bvo.setMemberVO(mvo);
		
		boardService.write(bvo);
	
		bvo.setMemberVO(mvo); //bvo와 mvo의 Hasing 관계가 성립된다..
		boardService.write(bvo); //w_date
		return new ModelAndView("board/show_content","bvo", bvo);
	}
	
	@RequestMapping("boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<BoardVO> list = boardService.findAll();	
		
		return new ModelAndView("board/show_content","list", list);
	}
	
	
	
}