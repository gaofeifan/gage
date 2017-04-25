package com.pj.customer.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.BaseController;
import com.pj.customer.pojo.CustomerBasic;
import com.pj.customer.service.CustomerBasicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 	用户基本信息
 *	@author		GFF
 *	@date		2017年4月20日上午11:28:13
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Api(value="CustomerBasicController", description="用户基本信息",position=1)
@Controller
@RequestMapping("/customer")
public class CustomerBasicController extends BaseController {

	@Resource
	private CustomerBasicService customerBasicService;
	
	/**
	 * 	添加用户
	 *	@author 	GFF
	 *	@date		2017年4月20日上午11:46:03	
	 * 	@param 		customerBasic
	 * 	@return
	 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperation(value = "添加", httpMethod = "POST", response=Map.class, notes ="添加")
	public Map<String,Object> add(@ModelAttribute("customerBasic") CustomerBasic customerBasic){
		this.customerBasicService.insertSelective(customerBasic);
		return this.success(null);
	}
	
	/**
	 * 	更新
	 *	@author 	GFF
	 *	@date		2017年4月20日上午11:46:43	
	 * 	@param 		customerBasic
	 * 	@return
	 */
	@RequestMapping("/update")
	@ResponseBody
	@ApiOperation(value = "更新", httpMethod = "POST", response=Map.class, notes ="更新")
	public Map<String,Object> update(@ModelAttribute("customerBasic") CustomerBasic customerBasic){
		this.customerBasicService.updateByPrimaryKeySelective(customerBasic);
		return this.success(null);
	}
	
	/**
	 * 	根据条件查询
	 *	@author 	GFF
	 *	@date		2017年4月20日上午11:46:53	
	 * 	@param 		customerBasic
	 * 	@return
	 */
	@RequestMapping("/select")
	@ResponseBody
	@ApiOperation(value = "根据条件查询", httpMethod = "POST", response=Map.class, notes ="根据条件查询")
	public Map<String,Object> select(@ModelAttribute("customerBasic") CustomerBasic customerBasic){
		List<CustomerBasic> list = this.customerBasicService.select(customerBasic);
		return this.success(list);
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String customerLogin(){
		return "login";
	}
	
}
