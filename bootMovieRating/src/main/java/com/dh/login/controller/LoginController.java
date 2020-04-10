package com.dh.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dh.common.controller.ComController;
import com.dh.login.service.LoginVO;
import com.dh.login.serviceimpl.LoginServiceimpl;

@Controller
@RequestMapping("/api/login/*")
@SessionAttributes(value="LoginVO")
public class LoginController extends ComController<LoginServiceimpl, LoginVO> {
	
	LoginController() {
		super();
	}

	//web-inf 밑의 jsp가 루트 경로
	@Autowired
	LoginServiceimpl loginService;		
	
	@ResponseBody 
	@PostMapping("/join")
	public String join(@RequestBody LoginVO vo) {
		System.out.println("회원가입");
		loginService.join(vo);
		return "success";
	}
	
}
