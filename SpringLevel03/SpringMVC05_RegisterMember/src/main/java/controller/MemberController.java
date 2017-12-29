package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.MemberService;
import model.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("register.do")
	public ModelAndView register(MemberVO vo) throws Exception{ // RequestMapping 으로 인해 ModelAndView(=String으로 타입변환가능), request, response 불필요
		memberService.registerMember(vo); //디비에 인자값으로 바인딩된 vo가 들어갔다.
		return new ModelAndView("redirect:allMember.do");
	}
	
	@RequestMapping("idcheck.do")
	public ModelAndView idcheck(String id) throws Exception{
		
		boolean flag = memberService.idcheck(id);
		
		return new ModelAndView("idcheck.jsp","flag", flag);
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, MemberVO vo) throws Exception{
		String path = "login_fail.jsp";
		MemberVO rvo = memberService.login(vo);
		System.out.println("vo :: "+vo); // address, name은 null로 나옴
		System.out.println("rvo :: "+rvo); // id, name, password, address 나옴
		
		if(rvo != null) {
			//중요!
			request.getSession().setAttribute("vo", rvo);
			path="login_ok.jsp";
		}
		
		return new ModelAndView(path); //이미 위에서 바인딩은 되었다.
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo") !=null) {
			session.invalidate(); // 세션해제
		}
			
		return new ModelAndView("index.jsp"); //이미 위에서 바인딩은 되었다.
	}
	
	@RequestMapping("updateMember.do")
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response, MemberVO vo) throws Exception{
		//인자값의 vo는 update.jsp 에서 수정된 값을 vo에 넣어서 가져온것.
		memberService.updateMember(vo); // DB에 수정된 vo를 업데이트 해주자.
		
		request.getSession().setAttribute("vo", vo); //session에다 수정된 것을  넣어주자.
		
		return new ModelAndView("update_result.jsp"); 
	}
	
	@RequestMapping("findByAddress.do")
	public ModelAndView findByAddress(HttpServletRequest request, HttpServletResponse response, String address) throws Exception{
		List<MemberVO> list = memberService.findByAddress(address);
		
		return new ModelAndView("findByAddress_result.jsp","list", list);
	}
	
	@RequestMapping("getAddressKind.do")
	public ModelAndView getAddressKind(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<String> list = memberService.getAddressKind();
		
		return new ModelAndView("findByAddress.jsp","list", list); //이미 위에서 바인딩은 되었다.
	}
	
	@RequestMapping("allMember.do")
	public ModelAndView allMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<MemberVO> allList = memberService.getAllMember();
		return new ModelAndView("allMember_result.jsp","allList",allList); //이미 위에서 바인딩은 되었다.
		
	}
}

