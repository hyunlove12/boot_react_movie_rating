package com.dh.common.service;

import java.io.Serializable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ComVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3055903559103023531L;	
	
	private String id = "";
	private String name = "";
	private String password = "";
	private String email = "";	
	private String role = "";
	private String username = "";
	private String regDt = "";
	private String unityGroupId = "";
	private String unityId = "";
	private String suserId = currentUserName();
	
	public String getUnityGroupId() {
		return unityGroupId;
	}
	public void setUnityGroupId(String unityGroupId) {
		this.unityGroupId = unityGroupId;
	}
	public String getUnityId() {
		return unityId;
	}
	public void setUnityId(String unityId) {
		this.unityId = unityId;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSuserId() {
		return suserId;
	}
	public void encodePassword(PasswordEncoder passwordEncoder) {
		this.password = passwordEncoder.encode(this.password);
	}
	
	public static String currentUserName() { 
		if(SecurityContextHolder.getContext().getAuthentication() != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
			return authentication.getName(); 			
		}
		return "";
		//Object principal = authentication.getPrincipal();				
	}

	
	
}
