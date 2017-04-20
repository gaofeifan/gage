package com.pj.goods.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.BaseController;
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
	@RequestMapping("/add.do")
	@ResponseBody
	@ApiOperation(value = "添加商品信息", httpMethod = "POST", response=Map.class, notes ="添加商品信息")
	public Map<String,Object> add(@ModelAttribute("shopGoods") ShopGoods shopGoods){
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
	@RequestMapping("/update.do")
	@ResponseBody
	@ApiOperation(value = "更新商品信息", httpMethod = "POST", response=Map.class, notes ="更新商品信息")
	public Map<String,Object> update(@ModelAttribute("shopGoods") ShopGoods shopGoods){
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
	@RequestMapping("/select.do")
	@ResponseBody
	@ApiOperation(value = "根据条件查询", httpMethod = "POST", response=Map.class, notes ="根据条件查询")
	public Map<String,Object> select(@ModelAttribute("shopGoods") ShopGoods shopGoods){
		List<ShopGoods> list = this.shopGoodsService.select(shopGoods);
		return this.success(list);
	}
	
	
}
