package com.pj.goods.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.BaseController;
import com.pj.config.page.Pagination;
import com.pj.goods.pojo.ShopGoods;
import com.pj.goods.service.ShopGoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 	商品信息
 *	@author		GFF
 *	@date		2017年4月20日上午11:28:13
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Api(value="ShopGoodsController", description="商品信息")
@RequestMapping("/goods")
@Controller
public class ShopGoodsController extends BaseController {

	@Resource
	private ShopGoodsService shopGoodsService;
	
	/**
	 * 	添加商品信息
	 *	@author 	GFF
	 *	@date		2017年4月20日上午11:46:03	
	 * 	@param 		shopGoods
	 * 	@return
	 */
	@RequestMapping("/saveShopGoods")
	@ResponseBody
	@ApiOperation(value = "添加商品信息", httpMethod = "POST", response=Map.class, notes ="添加商品信息")
	public Map<String,Object> saveShopGoods(@ModelAttribute("shopGoods") ShopGoods shopGoods){
		this.shopGoodsService.insertSelective(shopGoods);
		return this.success(null);
	}
	
	/**
	 * 	更新商品信息
	 *	@author 	GFF
	 *	@date		2017年4月20日上午11:46:43	
	 * 	@param 		shopGoods
	 * 	@return
	 */
	@RequestMapping("/updateShopGoods/")
	@ResponseBody
	@ApiOperation(value = "更新商品信息", httpMethod = "POST", response=Map.class, notes ="更新商品信息")
	public Map<String,Object> updateShopGoods(@ModelAttribute ShopGoods shopGoods){
		this.shopGoodsService.updateByPrimaryKeySelective(shopGoods);
		return this.success(null);
	}
	
	/**
	 * 	根据条件查询
	 *	@author 	GFF
	 *	@date		2017年4月20日上午11:46:53	
	 * 	@param 		shopGoods
	 * 	@return
	 */
	@RequestMapping(value="/selectByInfo",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据条件查询", httpMethod = "GET", response=Map.class, notes ="根据条件查询")
	public Map<String,Object> selectByInfo(	@ModelAttribute ShopGoods shopGoods , @RequestParam(value="pageNo",required=false) Integer pageNo
										 /*@PathVariable("goodsName")String goodsName,
									       @PathVariable("goodsType")Integer goodsType,
									       @PathVariable("priceMin")Integer priceMin,
									       @PathVariable("priceMax")Integer priceMax*/){
		Pagination pagination = this.shopGoodsService.selectByInfo(shopGoods.getGoodsName(),shopGoods.getGoodsType(),shopGoods.getPriceMin(),shopGoods.getPriceMax(),pageNo);
		return this.success(pagination);
	}

	/**
	 * 	查询商品详情
	 *	@author 	GFF
	 *	@date		2017年4月21日上午11:09:09	
	 * 	@param 		id
	 * 	@return
	 */
	@RequestMapping(value="/selectById",method={RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "根据id查询商品详情", httpMethod = "GET", response=Map.class, notes ="根据id查询商品详情")
	public Map<String,Object> selectById(@RequestParam("id") Integer id,HttpServletRequest request,HttpServletResponse response){
		ShopGoods shopGoods = this.shopGoodsService.selectByPrimaryKey(id);
		return this.success(shopGoods);
	}
	
	
}
