package com.pj.utils.enums;

/**
 *	@author		GFF
 *	@date		2017年4月13日下午5:31:29
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public enum ExceptionEnum {

	HANDLE_EXCEPTION("400" , "操作资源异常"),
	USERNAME_OR_PASSWORD_WRONG("401" ,"用户名或密码错误");
	private String code;
	private String msg;
	
	
	private ExceptionEnum(String code, String msg) {
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
