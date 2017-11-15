package com.kosta.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosta.spring.service.MemberService;
import com.kosta.spring.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//회원 가입 폼
	@RequestMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	//회원 가입하기
	@RequestMapping("/member/join")
	public String joinMember(Member member) {
		memberService.joinMember(member);
		return "member/joinSuccess";
	}
	
	//로그인 폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	//관리자 페이지
	@RequestMapping("/admin/main")
	public String adminMain() {
		return "admin/main";
	}
	
	//일반 회원 페이지
	@RequestMapping("/member/main")
	public String memberMain() {
		return "member/main";
	}
}














