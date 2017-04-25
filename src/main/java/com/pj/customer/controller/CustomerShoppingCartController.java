package com.pj.customer.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.BaseController;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.service.CustomerShoppingCartService;

import io.swagger.annotations.ApiOperation;

/**
 *	@author		GFF
 *	@date		2017年4月21日上午11:10:54
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Controller
@RequestMapping("/shoppingCart")
public class CustomerShoppingCartController extends BaseController{

	@Resource
	private CustomerShoppingCartService customerShoppingCartService;
	
	
	@RequestMapping(value="/index")
	public String initShoppingCart(){
		return "customer/checkout";
	}
	
	/**
	 * 	添加购物车
	 *	@author 	GFF
	 *	@date		2017年4月21日上午11:36:45	
	 * 	@param customerShoppingCart
	 * 	@return
	 */
	@ApiOperation(value = "添加购物车", httpMethod = "POST", response=Map.class, notes ="添加购物车")
	@RequestMapping(value="/saveCustomerShoppingCart",method={RequestMethod.POST})
	public @ResponseBody Map<String,Object> saveCustomerShoppingCart(@ModelAttribute("customerShoppingCart")CustomerShoppingCart customerShoppingCart){
		customerShoppingCartService.insertSelective(customerShoppingCart);
		return this.success(null);
	}
	
	/**
	 * 	更新购物车中的商品
	 *	@author 	GFF
	 *	@date		2017年4月21日上午11:50:21	
	 * 	@param customerShoppingCart
	 * 	@return
	 */
	@ApiOperation(value = "更新购物车中的商品", httpMethod = "POST", response=Map.class, notes ="更新购物车中的商品")
	@RequestMapping(value="/updateCustomerShoppingCart",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> updateCustomerShoppingCart(@ModelAttribute("customerShoppingCart")CustomerShoppingCart customerShoppingCart){
		this.customerShoppingCartService.updateByPrimaryKeySelective(customerShoppingCart);
		return this.success(null);
	}
	
	/**
	 * 	查看购物车
	 *	@author 	GFF
	 *	@date		2017年4月21日下午1:58:56	
	 * 	@return
	 */
	@ApiOperation(value = "查看购物车", httpMethod = "GET", response=Map.class, notes ="查看购物车车")
	@RequestMapping(value="/selectCustomerShoppingCartAll",method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> selectCustomerShoppingCartAll(){
		List<CustomerShoppingCart> list = this.customerShoppingCartService.selectAll();
		return this.success(list);
	}
	
	@ApiOperation(value = "删除购物车中的商品", httpMethod = "DELETE", response=Map.class, notes ="查看购物车车")
	@RequestMapping(value="/deleteCustomerShoppingCart/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String,Object> delete(@PathVariable("id") Integer id){
		this.customerShoppingCartService.deleteByPrimaryKey(id);
		return this.success(null);
	}
	
	/**
	 * 	根据ids查询购物车
	 *	@author 	GFF
	 *	@date		2017年4月21日下午3:09:19	
	 * 	@param ids
	 * 	@return
	 */
	@RequestMapping(value="/selectByIds",method={RequestMethod.GET})
	@ResponseBody
	@ApiOperation(value = "根据id查询购物车", httpMethod = "GET", response=Map.class, notes ="根据id查询购物车")
	public Map<String,Object> selectByIds(@RequestParam(value="ids") Integer[] ids){
		List<CustomerShoppingCart> list = this.customerShoppingCartService.selectByIds(ids);
		return this.success(list);
	}
	
}
