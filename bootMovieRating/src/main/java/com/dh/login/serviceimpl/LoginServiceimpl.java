package com.dh.login.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dh.login.service.LoginService;
import com.dh.login.service.LoginVO;

@Service("LoginService")
public class LoginServiceimpl implements LoginService, UserDetailsService {
	
	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public boolean join(LoginVO vo) {
		boolean boo = false;
		int result = 0;
		vo.encodePassword(passwordEncoder);
		result += loginMapper.join(vo);
		result += loginMapper.roleRegist(vo);
		if(result >= 2) {
			boo = true;
		}
		return boo;
	}	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//UserDtails가 Account객체와 Principal과의 어댑터 역할
		//UserDetailsService -> DAO를 이용하여 user정보 인증
		//username을 이용하여 유저정보를 받아와서 userdetails로 리턴
		LoginVO account = loginMapper.findByUsername(username); //springjpa 가 자동으로 쿼리 생성
		if (account == null) {
			throw new UsernameNotFoundException(username);
		}
		
		List<String> roleList = new ArrayList<String>();
		roleList = loginMapper.findByRoleList(username);
		String[] roleListArray = roleList.toArray(new String[roleList.size()]);
		//account를 userdetails로 변환
		return User.builder()
				.username(account.getId())
				.password(account.getPassword())	//최초 id생성시 encoder를 안타고 생성해서 필요한 것??
				//ROLE_라는 것을 붙여준다 -> 생성자에서
				.roles(roleListArray)				
				.build();
	}

	
}
