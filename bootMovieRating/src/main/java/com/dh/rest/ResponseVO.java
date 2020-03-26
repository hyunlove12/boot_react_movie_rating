package com.dh.rest;

import java.io.Serializable;

public class ResponseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2014712058141040914L;

	private String status = "";
	private String message = "";
	private String errMessgae = "";
	private String errCode = "";
	private boolean success = true;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrMessgae() {
		return errMessgae;
	}
	public void setErrMessgae(String errMessgae) {
		this.errMessgae = errMessgae;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
