package com.pj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

/**
 * 	订单地址详情
 *	@author		GFF
 *	@date		2017年4月20日上午11:28:13
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Api(value="OrderAddressController", description="订单地址详情")
@Controller
@RequestMapping("/oa")
public class OrderAddressController extends BaseController {

}
