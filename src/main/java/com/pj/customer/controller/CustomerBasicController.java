package com.pj.customer.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pj.config.base.BaseController;
import com.pj.customer.pojo.CustomerBasic;
import com.pj.customer.service.CustomerBasicService;
import com.pj.utils.enums.ExceptionEnum;
import com.pj.utils.enums.Result;

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
	
	@RequestMapping(value="/customerLogin",method=RequestMethod.GET)
	public ModelAndView customerLogin(@RequestParam(value="username",required=false)String username , @RequestParam(value="password",required=false)String password , HttpServletRequest request , HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		if(StringUtils.isNoneBlank(password) || StringUtils.isNoneBlank(password) ){
			List<CustomerBasic> list = this.customerBasicService.select(new CustomerBasic(username));
			if(list.size() != 0){
				CustomerBasic customerBasic = list.get(0);
				if(customerBasic.getPassword().equals(DigestUtils.md5Hex(password))){
					HttpSession session = request.getSession();
					session.setAttribute("customerId",customerBasic.getId() );
					try {
						response.sendRedirect("http://localhost:8080/gage/goods/index");
						return null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		view.setViewName("login");
		view.addObject("msg", ExceptionEnum.USERNAME_OR_PASSWORD_WRONG.getMsg());
		return view;
	}
/*	@RequestMapping(value="/customerLogin",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String,Object> customerLogin(@RequestParam(value="username",required=false)String username , @RequestParam(value="password",required=false)String password , HttpServletRequest request , HttpServletResponse response){
		if(StringUtils.isNoneBlank(password) || StringUtils.isNoneBlank(password) ){
			List<CustomerBasic> list = this.customerBasicService.select(new CustomerBasic(username));
			if(list.size() != 0){
				CustomerBasic customerBasic = list.get(0);
				if(customerBasic.getPassword().equals(DigestUtils.md5Hex(password))){
					HttpSession session = request.getSession();
					session.setAttribute("customerId",customerBasic.getId() );
					return this.success("登录成功");
				}
			}
		}
		return this.error(ExceptionEnum.USERNAME_OR_PASSWORD_WRONG);
	}*/
	
	/**
	 * 	查询当前登录状态
	 *	@author 	GFF
	 *	@date		2017年4月27日下午3:29:25	
	 * 	@return
	 */
	@RequestMapping(value="/selectLoginStatus",method=RequestMethod.GET)
	public @ResponseBody Map<String , Object> selectLoginStatus(HttpServletRequest request){
		Integer customerId = this.getCustomerId(request);
		if(customerId != null){
			return this.success(Result.YES_LOGIN.getCode());
		}
		return this.success(Result.NOT_LOGIN.getCode());
	}
	
}
