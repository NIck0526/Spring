package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.PersonVO;

@Controller
public class AjaxJsonController {

	@RequestMapping("synch.do")
	public String insert(HttpServletRequest request) {
		System.out.println("동기통신 호출... insert ...");
		return "insertOK";
	}
	
	@RequestMapping("searchById.do")
	public ModelAndView ssearchById() {
		System.out.println("비동기통신 호출... searchById ...");
		return new ModelAndView("JsonView", "person", new PersonVO("클라라","서초동")); 
		// 별도의 view 페이지가 없기에BeanNameViewResolve 설정이 필요한거임
	}
	
	
}
