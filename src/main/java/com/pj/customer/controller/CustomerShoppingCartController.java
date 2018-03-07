package com.pj.customer.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.BaseController;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.pojo.CustomerShoppingCartGoodsConcern;
import com.pj.customer.service.CustomerShoppingCartGoodsConcernService;
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
	
	@Resource
	private CustomerShoppingCartGoodsConcernService customerShoppingCartGoodsConcernService;
	
	@RequestMapping(value="/index")
	public String initShoppingCart(){
		return "customer/checkout";
	}
	
	public static final Integer customerId = 1;
	
	/**
	 * 	给购物车添加商品
	 *	@author 	GFF
	 *	@date		2017年4月21日上午11:36:45	
	 * 	@param customerShoppingCart
	 * 	@return
	 */
	@ApiOperation(value = "给购物车添加商品", httpMethod = "POST", response=Map.class, notes ="添加购物车")
	@RequestMapping(value="/saveCustomerShoppingCart",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody Map<String,Object> saveCustomerShoppingCart(@ModelAttribute("shoppingCartGoods")CustomerShoppingCartGoodsConcern shoppingCartGoods , HttpServletRequest request){
		shoppingCartGoods.setShopCartId(getShoppingCartByCustomerId(request));
		this.customerShoppingCartGoodsConcernService.insertSelective(shoppingCartGoods);
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
	@RequestMapping(value="/updateCustomerShoppingCart",method={RequestMethod.POST})
	public @ResponseBody Map<String,Object> updateCustomerShoppingCart(@RequestParam("goodsId")Integer goodsId , @RequestParam("goodsNum")Integer goodsNum ,HttpServletRequest request){
		int shoppingCartId = getShoppingCartByCustomerId(request);
		this.customerShoppingCartGoodsConcernService.updateByPrimaryKeySelective(new CustomerShoppingCartGoodsConcern(shoppingCartId, goodsId, goodsNum));
		return this.success(null);
	}
	
	/**
	 * 	查看购物车
	 *	@author 	GFF
	 *	@date		2017年4月21日下午1:58:56	
	 * 	@return
	 */
	@ApiOperation(value = "查看购物车", httpMethod = "GET", response=Map.class, notes ="查看购物车车")
	@RequestMapping(value="/selectCustomerShoppingCartAll",method=RequestMethod.GET )
	public @ResponseBody Map<String,Object> selectCustomerShoppingCartAll(HttpServletRequest request){
		int id = getShoppingCartByCustomerId(request);
		CustomerShoppingCart shoppingCart = this.customerShoppingCartService.selectByPrimaryKey(id);
		return this.success(shoppingCart);
	}
	
	/**
	 * 	删除购物车中的商品
	 *	@author 	GFF
	 *	@date		2017年4月25日下午2:56:13	
	 * 	@param goodsId
	 * 	@return
	 */
	@ApiOperation(value = "删除购物车中的商品", httpMethod = "DELETE", response=Map.class, notes ="查看购物车车")
	@RequestMapping(value="/deleteCartItem",method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> deleteCartItem(@RequestParam("goodsId") Integer goodsId ,HttpServletRequest request){
		int cartId = getShoppingCartByCustomerId(request);
		this.customerShoppingCartGoodsConcernService.delete(new CustomerShoppingCartGoodsConcern(cartId, goodsId));
		return this.success(null);
	}
	
	/**
	 * 	查询被选中购物车中的商品
	 *	@author 	GFF
	 *	@date		2017年4月21日下午3:09:19	
	 * 	@param ids
	 * 	@return
	 */
	@RequestMapping(value="/selectByShoppingCartAndGoodsIds",method={RequestMethod.GET})
	@ResponseBody
	@ApiOperation(value = "根据id查询购物车", httpMethod = "GET", response=Map.class, notes ="根据id查询购物车")
	public Map<String,Object> selectByShoppingCartAndGoodsIds(@RequestParam(value="ids") Integer[] ids , HttpServletRequest request){
		int cartId = getShoppingCartByCustomerId(request);
		CustomerShoppingCart shoppingCart = this.customerShoppingCartService.selectByShoppingCartAndGoodsIds(cartId,ids);
		return this.success(shoppingCart);
	}
	
}
