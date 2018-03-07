package com.pj.config.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *	@author		GFF
 *	@date		2017年4月25日下午5:33:20
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class LoginInterceptor extends HandlerInterceptorAdapter  {

	private List<String> excludedUrls;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUri = request.getRequestURI();
 		for (String uri : excludedUrls) {
			if (requestUri.endsWith(uri)) {
				return true;
			}
		}
		HttpSession session = request.getSession();
		Object object = session.getAttribute("customerId");
		if(object != null){
			return true;
		}
//		 request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response); 
		 response.sendRedirect("http://Localhost:8080/gage/customer/login");
		return false;
	}

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}
	
	

}
