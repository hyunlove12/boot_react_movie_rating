package com.dh.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dh.common.service.ComVO;

@Controller
public abstract class ComController<S, V> extends AbstractController{
	//web-inf 밑의 jsp가 루트 경로
	@Autowired
	S service;
	
	public ComController() {
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String userId = ComVO.currentUserName();
		ModelAndView view = new ModelAndView();
		view.addObject("userId", userId);
		System.out.println("@handleRequestInternal@" + userId);
		return view;
	}
	
	@RequestMapping("/list") 
	public String list(HttpServletResponse response, HttpServletRequest req, ModelAndView model, V vo) { 
		//service.list();
		return "login/main"; 
	}

	@RequestMapping("/search")
	public String search(HttpServletResponse response, HttpServletRequest req, ModelAndView model, V vo) {			
		return "login/login";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletResponse response, HttpServletRequest req, ModelAndView model, V vo) {			
		return "login/login";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletResponse response, HttpServletRequest req, ModelAndView model, V vo) {			
		return "login/login";
	}

	

}
