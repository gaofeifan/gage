package com.pj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

/**
 * 	订单基本信息
 *	@author		GFF
 *	@date		2017年4月20日上午11:28:13
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Api(value="OrderBasicController", description="订单基本信息")
@Controller
@RequestMapping("/oc")
public class OrderBasicController extends BaseController {

}
