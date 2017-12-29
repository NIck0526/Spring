package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	
	 @Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// biz logic call...
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("message", "Hello First String MVC!!");
		
		return mv;
	}
}






	