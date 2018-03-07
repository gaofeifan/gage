package com.pj.config.base;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.service.CustomerShoppingCartService;
import com.pj.utils.enums.ExceptionEnum;
public class BaseController{
	protected Logger logger = LoggerFactory.getLogger(BaseController.class); 
	
	@Resource
	private CustomerShoppingCartService customerShoppingCartService;
	
	public Map<String,Object> success(Object data){
		Map<String,Object> datas=new HashMap<String, Object>();
		datas.put("status",true);
		datas.put("msg","操作成功");
		datas.put("code","200");
		datas.put("data",data);
		return datas;
	}
	
	public Map<String,Object> error(ExceptionEnum exceptionEnum){
		Map<String,Object> data=new HashMap<String, Object>();
		data.put("status",false);
		data.put("msg",exceptionEnum.getMsg());
		data.put("code",exceptionEnum.getCode());
		return data;
	}
	
	public Map<String,Object> error(Object data){
		Map<String,Object> datas=new HashMap<String, Object>();
		datas.put("status",false);
		datas.put("msg",data);
		datas.put("code","400");
		datas.put("data","操作失败:"+data);
		return datas;
	}
	
	/**
	 * 	获取当前登录人
	 *	@author 	GFF
	 *	@date		2017年4月26日下午6:15:55	
	 * 	@param request
	 * 	@return
	 */
	public Integer getCustomerId(HttpServletRequest request){
		HttpSession session = request.getSession();
		Object object = session.getAttribute("customerId");
		if(object != null){
			return Integer.decode(object.toString());
		}
		return null;
	}
	
	/**
	 * 	根据当前登录人获取购物车
	 *	@author 	GFF
	 *	@date		2017年4月26日下午6:15:36	
	 * 	@param request
	 * 	@return
	 */
	public Integer getShoppingCartByCustomerId(HttpServletRequest request){
		Integer customerId = getCustomerId(request);
		List<CustomerShoppingCart> list = this.customerShoppingCartService.select(new CustomerShoppingCart(null,customerId));
		if(list.size() == 0){
			CustomerShoppingCart cart = new CustomerShoppingCart();
			cart.setCustomerId(customerId);
			this.customerShoppingCartService.insertSelective(cart);
			return cart.getId();
		}
		return list.get(0).getId();
	}
}
