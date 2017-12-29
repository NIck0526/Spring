package com.kosta.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.spring.model.BoardVO;
import com.kosta.spring.model.MemberVO;
import com.kosta.spring.service.BoardService;
import com.kosta.spring.service.ListVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response, BoardVO bvo) throws Exception{
		
		System.out.println("1. writeController...."+bvo);
		MemberVO mvo = (MemberVO)request.getSession().getAttribute("mvo"); // session에 바인딩된 로그인아이디(mvo)를 가져옴 
		if(mvo == null) return new ModelAndView("redirect:/index.jsp");
		
		//로그인 한 상태라면
		bvo.setMemberVO(mvo); //bvo와 mvo의 Hasing 관계가 성립된다..
		boardService.write(bvo); //w_date
		return new ModelAndView("board/show_content","bvo", bvo);
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, String pageNo) throws Exception{
		ListVO lvo = boardService.getBoardList(pageNo);
		
		return new ModelAndView("board/list", "lvo", lvo);
	}
	
	@RequestMapping("showContent.do")
	public ModelAndView showContent(HttpServletRequest request, HttpServletResponse response, String no) throws Exception{
		
		//로그인한 사람만
		MemberVO mvo = 	(MemberVO)request.getSession().getAttribute("mvo");
		if(mvo==null){
			return new ModelAndView("redirect:/index.jsp");
		}
		
		boardService.updateCount(no);
		BoardVO bvo = boardService.showContent(no);
		return new ModelAndView("board/show_content", "bvo", bvo);
	}
	
	@RequestMapping("delete.do")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, String no) throws Exception{
		
		boardService.delete(no);
		

		/*return new ModelAndView("redirect:/list.do");*/
		
		ListVO lvo = boardService.getBoardList("1");
		return new ModelAndView("board/list","lvo",lvo);
	}
		
	
	@RequestMapping("updateView.do")
	public ModelAndView updateView(String no) throws Exception{
	
		BoardVO bvo = boardService.showContent(no);
		return new ModelAndView("board/update","bvo", bvo);
	}
	
	
	
	@RequestMapping("update.do")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response, BoardVO bvo) throws Exception{
		
		boardService.update(bvo);
		
		return new ModelAndView("board/show_content", "bvo", boardService.showContent(bvo.getNo()+""));
	}

}



