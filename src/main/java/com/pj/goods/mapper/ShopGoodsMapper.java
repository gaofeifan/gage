package com.pj.goods.mapper;

import java.util.List;

import com.pj.config.base.MyMapper;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.goods.pojo.ShopGoods;

public interface ShopGoodsMapper extends MyMapper<ShopGoods> {

	List<ShopGoods> selectByInfo(ShopGoods shopGoods);

	Integer selectByInfoCount(ShopGoods shopGoods);

	/**
	 * 	根据订单查询商品
	 *	@author 	GFF
	 *	@date		2017年4月24日下午6:24:45	
	 * 	@param id
	 */
	List<ShopGoods> selectShopGoodsByOderBasicId(Integer id);

	/**
	 * 	查询购物车中的商品
	 *	@author 	GFF
	 *	@date		2017年4月25日下午1:40:39	
	 * 	@param key
	 * 	@return
	 */
	List<ShopGoods> selectShopGoodsByShoppingCartIdAndGoodsIds(CustomerShoppingCart customerShoppingCart);

	/**
	 * 	查询购物车中的所有商品
	 *	@author 	GFF
	 *	@date		2017年4月25日下午2:53:19	
	 * 	@param key
	 * 	@return
	 */
	List<ShopGoods> selectShopGoodsByShoppingCartId(Integer key);
}