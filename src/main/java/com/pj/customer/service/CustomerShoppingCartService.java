package com.pj.customer.service;

import java.util.List;

import com.pj.config.base.BaseService;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.goods.pojo.ShopGoods;

/**
 *	@author		GFF
 *	@date		2017年4月21日上午9:39:52
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public interface CustomerShoppingCartService extends BaseService<CustomerShoppingCart, Integer> {

	/**
	 * 	根据id查询购物车中的商品
	 *	@author 	GFF
	 *	@date		2017年4月21日下午3:10:28	
	 * 	@param ids
	 * 	@return
	 */
	CustomerShoppingCart selectByShoppingCartAndGoodsIds(int cartId, Integer[] ids);


}
