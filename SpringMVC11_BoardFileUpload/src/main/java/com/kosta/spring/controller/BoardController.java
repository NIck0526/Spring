package com.kosta.spring.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
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
		/*boardService.write(bvo); //w_date */
		
		//파일 업로드
		MultipartFile mfile = bvo.getUploadFile(); // 내가 선택한 파일
		System.out.println("MultipartFile :: "+mfile);
		
		if(mfile.isEmpty()==false) {
		
			//orgfilename 받아와서 bvo에 주입
			//이름 넣기
			String fileName = mfile.getOriginalFilename();
			bvo.setOrgfilename(fileName);
			
			String newfilename = System.currentTimeMillis()+"_"+fileName;
			bvo.setNewfilename(newfilename);
			
		/*//시간 구하기
		
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyMMddHHmmssSSS"); 
		String strDT = dayTime.format(new Date(time)); 
		System.out.println("밀리세컨드 시간 :: "+strDT); */
		
		
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		System.out.println("upload_path :: "+path);
		
		File copyFile = new File(path+newfilename);
		mfile.transferTo(copyFile); // upload폴더에 newfilename이 저장
		
		}//if
		
		boardService.write(bvo); //w_date & upload
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
	
	@RequestMapping("deleteBoard.do")
	public ModelAndView delete(HttpServletRequest request, String no, String newfilename) throws Exception{
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		//upload폴더에서 삭제
		boardService.deleteFile(path+newfilename);
		
		
		//실제 DB에서 삭제
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
	
	
	
	@RequestMapping("updateBoard.do")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response, BoardVO bvo) throws Exception{
		
		//파일 업로드
				MultipartFile mfile = bvo.getUploadFile(); // 내가 선택한 파일
				System.out.println("MultipartFile :: "+mfile);
				
				if(mfile.isEmpty()==false) {
				
					//orgfilename 받아와서 bvo에 주입
					//이름 넣기
					String fileName = mfile.getOriginalFilename();
					bvo.setOrgfilename(fileName);
					
					String newfilename = System.currentTimeMillis()+"_"+fileName;
					bvo.setNewfilename(newfilename);
				
				
				String root = request.getSession().getServletContext().getRealPath("/");
				String path = root+"\\upload\\";
				System.out.println("upload_path :: "+path);
				
				File copyFile = new File(path+newfilename);
				mfile.transferTo(copyFile); // upload폴더에 newfilename이 저장
				
				}//if
		
		boardService.update(bvo);
		
		return new ModelAndView("board/show_content", "bvo", boardService.showContent(bvo.getNo()+""));
	}
	
	@RequestMapping("fileDown.do")
	public ModelAndView fileDown(HttpServletRequest request, String orgfilename, String newfilename)throws Exception{
		/*String fileName = request.getParameter("fileName");
		System.out.println("fileName :: "+fileName);*/
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		
		Map map = new HashMap();
		map.put("path", path);		
		
		return new ModelAndView("downloadView",map); // context에서 지정했기 annotation지정하였기 때문에 바로 찾아감.
		// orgfilename 이랑 newfilename은 어떻게 downloadView로 넘어감?
	}
	
	@RequestMapping("removeFile.do")
	
	public ModelAndView delete(HttpServletRequest request, String newfilename) throws Exception{
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		
		//upload폴더에서 삭제
		boardService.deleteFile(path+newfilename);
				
	
		return new ModelAndView("JasonView");
	}
	
}



