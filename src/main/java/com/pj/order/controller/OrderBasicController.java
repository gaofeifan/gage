package com.pj.order.controller;

import java.util.Arrays;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.BaseController;
import com.pj.customer.controller.CustomerShoppingCartController;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.order.pojo.OrderBasic;
import com.pj.order.service.OrderBasicService;
import com.pj.utils.ExcleUtils;

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
	
	@ApiOperation(value = "添加订单", httpMethod = "POST", response=Map.class, notes ="添加订单")
	@RequestMapping(value="/saveOrderBasic",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveOrderBasic(OrderBasic orderBasic){
		CustomerShoppingCartController shoppingCartController = new CustomerShoppingCartController();
		int cartId = shoppingCartController.getShoppingCartByCustomerId(CustomerShoppingCartController.customerId);
		this.orderBasicService.insertSelective(orderBasic,cartId);
		return this.success(null);
	}

	@ApiOperation(value = "导出订单详情", httpMethod = "POST", response=Map.class, notes ="添加订单")
	@RequestMapping(value="/exportOrderExcel",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> exportOrderExcel(Integer orderId){
		OrderBasic orderBasic = this.orderBasicService.selectOrderById(orderId);
		Arrays.asList("订单编号","");
		ExcleUtils.exportExcel2(null, orderBasic);
		return null;
	}
	
}
