package com.pj.goods.service;

import java.util.List;

import com.pj.config.base.BaseService;
import com.pj.goods.pojo.ShopGoods;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午11:13:19
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface ShopGoodsService extends BaseService<ShopGoods, Integer> {

	/**
	 * 	根据条件查询商品
	 *	@author 	GFF
	 *	@date		2017年4月21日下午2:28:09	
	 * 	@param goodsName
	 * 	@param goodsType
	 * 	@param priceMin
	 * 	@param priceMax
	 * 	@return
	 */
	public List<ShopGoods> selectByInfo(String goodsName, Integer goodsType, Integer priceMin, Integer priceMax);

}
