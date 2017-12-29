package com.kosta.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class loginController {

	@RequestMapping("/main")
	public String main() {
		return "/user/main";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/user/login";
	}
}
