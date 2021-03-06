package com.pj.order.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.BaseController;
import com.pj.order.pojo.OrderAddress;
import com.pj.order.service.OrderAddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *	@author		GFF
 *	@date		2017年4月21日下午3:32:03
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Api(value="OrderAddressController", description="订单地址详情")
@RequestMapping("/order/address")
@Controller
public class OrderAddressController extends BaseController {

	@Resource
	private OrderAddressService orderAddressService;
	
	/**
	 * 	添加订单的收获地址
	 *	@author 	GFF
	 *	@date		2017年4月21日下午3:34:30	
	 * 	@param orderAddress
	 * 	@return
	 */
	@ApiOperation(value = "添加订单的收获地址", httpMethod = "POST", response=Map.class, notes ="添加订单的收获地址")
	@RequestMapping(value="/saveOrderAddress",method=RequestMethod.POST)
	public @ResponseBody Map<String , Object> saveOrderAddress(@ModelAttribute("orderAddress")OrderAddress orderAddress){
		this.orderAddressService.insertSelective(orderAddress);
		return this.success(orderAddress.getId());
	}
	
	/**
	 * 	查询所有的收获地址
	 *	@author 	GFF
	 *	@date		2017年4月24日下午2:57:01	
	 * 	@return
	 */
	@ApiOperation(value = "查询收获地址", httpMethod = "GET", response=Map.class, notes ="查询收获地址")
	@RequestMapping(value="/selectOrderAddressAll",method=RequestMethod.GET)
	public @ResponseBody Map<String , Object> selectOrderAddressAll(){
		List<OrderAddress> list = this.orderAddressService.selectAll();
		return this.success(list);
	}
	
	/**
	 * 	根据id查询地址
	 *	@author 	GFF
	 *	@date		2017年4月24日下午2:57:01	
	 * 	@return
	 */
	@ApiOperation(value = "查询收获地址", httpMethod = "GET", response=Map.class, notes ="查询收获地址")
	@RequestMapping(value="/selectOrderAddressById",method=RequestMethod.GET)
	public @ResponseBody Map<String , Object> selectOrderAddressById(@RequestParam("id") Integer id){
		OrderAddress orderAddress = this.orderAddressService.selectByPrimaryKey(id);
		return this.success(orderAddress);
	}

	/**
	 * 	更新订单地址
	 *	@author 	GFF
	 *	@date		2017年4月24日下午2:57:01	
	 * 	@return
	 */
	@ApiOperation(value = "更新订单地址", httpMethod = "POST", response=Map.class, notes ="更新订单地址")
	@RequestMapping(value="/updateOrderAddressById",method=RequestMethod.POST)
	public @ResponseBody Map<String , Object> updateOrderAddressById(@ModelAttribute("orderAddress")OrderAddress orderAddress){
		this.orderAddressService.updateByPrimaryKeySelective(orderAddress);
		return this.success(null);
	}
	
	/**
	 * 	根据购物车id查询地址
	 *	@author 	GFF
	 *	@date		2017年4月24日下午2:57:01	
	 * 	@return
	 */
	@ApiOperation(value = "根据购物车id查询地址", httpMethod = "POST", response=Map.class, notes ="更新订单地址")
	@RequestMapping(value="/selectOrderAddressByShoppingCartId",method=RequestMethod.POST)
	public @ResponseBody Map<String , Object> selectOrderAddressByShoppingCartId(@RequestParam("shoppingCartId")Integer shoppingCartId){
		List<OrderAddress> list = this.orderAddressService.select(new OrderAddress(null, shoppingCartId));
		return this.success(list.size() != 0 ? list.get(0) : null);
	}
	
	
}
