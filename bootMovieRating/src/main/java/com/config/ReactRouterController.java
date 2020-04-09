package com.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/*")
@Controller
public class ReactRouterController{	

	// 임시로 라우터 이동 리소스 처리
	@RequestMapping
	public String main() {
		System.out.println("메인 호출!!!");
		return "welcome";
	}

}
