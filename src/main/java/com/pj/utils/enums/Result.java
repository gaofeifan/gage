package com.pj.utils.enums;

/**
 *	@author		GFF
 *	@date		2017年4月27日下午3:36:00
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public enum Result {
	YES_LOGIN("1" ,"已登录"),
	NOT_LOGIN("0","未登录");
	private String code;
	private String msg;
	
	
	private Result(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
