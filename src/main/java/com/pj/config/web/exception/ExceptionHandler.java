package com.pj.config.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.pj.utils.enums.ExceptionEnum;

public class ExceptionHandler implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("msg", ExceptionEnum.HANDLE_EXCEPTION.getMsg());
			modelAndView.setViewName("error/error");
			System.out.println(exception.getMessage());
			return modelAndView;
			
		

		
	}

}
