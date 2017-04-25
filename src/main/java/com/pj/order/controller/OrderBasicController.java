package com.pj.order.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.BaseController;
import com.pj.order.pojo.OrderBasic;
import com.pj.order.service.OrderBasicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 	订单详情
 *	@author		GFF
 *	@date		2017年4月20日上午11:28:13
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Api(value="OrderController", description="订单详情")
@RequestMapping("/order")
@Controller
public class OrderBasicController extends BaseController {

	@Resource
	private OrderBasicService orderBasicService;
	
	@RequestMapping(value="index",method = RequestMethod.GET)
	public String orderInit(){
		return "order/orderBasic";
	}
	
	@ApiOperation(value = "添加订单", httpMethod = "POST", response=Map.class, notes ="添加订单")
	@RequestMapping(value="/saveOrderBasic",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveOrderBasic(OrderBasic orderBasic){
		this.orderBasicService.insertSelective(orderBasic);
		return null;
		
	}
	
}
