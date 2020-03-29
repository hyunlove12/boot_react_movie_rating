package com.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class CustomHandlerInterceptor implements HandlerInterceptor  {
	@Override

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
		// redirect도 똑같이 인터셉터가 적용되는가? -> 맞는듯...
		// 로그인 여부에 따라 다르게 -> 로그인 한 경우 메인 / 로그인 안 한경우 로그인 페이지
		// 없는 주소로 들어왔을 경우 적절판 페이지로 보내주지 못한다. -> 우선적으로 예외 처리 , 로그인 등 처리 후 
		// 이렇게 하면 리액트 라우터가 작동...x
		//response.sendRedirect("/main");
		return true;
	}
	
}
