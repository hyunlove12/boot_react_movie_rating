package com.dh.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dh.common.controller.ComController;
import com.dh.login.service.LoginVO;
import com.dh.login.serviceimpl.LoginServiceimpl;

@Controller
@SessionAttributes(value="LoginVO")
public class LoginController extends ComController<LoginServiceimpl, LoginVO> {
	
	LoginController() {
		super();
	}

	//web-inf 밑의 jsp가 루트 경로
	@Autowired
	LoginServiceimpl loginService;
	

	@RequestMapping("/log")
	public String loginPage(HttpServletResponse response, HttpServletRequest req, ModelAndView model, LoginVO vo) {			
		System.out.println("호출!!!!!!!!!!!!");
//		return "login/login.html";
		return "welcome";
	} 
	@RequestMapping("/ratingmain")
	public String ratingmain(HttpServletResponse response, HttpServletRequest req, ModelAndView model, LoginVO vo) {			
		System.out.println("ratingmain");
//		return "login/login.html";
		return "welcome";
	} 

	
//	@RequestMapping(value="/save.do", produces="text/plain;charset=UTF-8")
	@PostMapping(value="/join/join")
	public String join(HttpServletResponse response, HttpServletRequest req, ModelAndView model, LoginVO vo) throws IOException {
		loginService.join(vo);		
		return "redirect:/main"; 
	}
	
	@GetMapping("/join/join")
	public String join(HttpServletResponse res, HttpServletRequest req) {			
		return "login/join";
	}
}
