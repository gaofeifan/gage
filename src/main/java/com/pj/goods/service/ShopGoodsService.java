package com.pj.goods.service;

import java.util.List;

import com.pj.config.base.BaseService;
import com.pj.config.page.Pagination;
import com.pj.customer.pojo.CustomerShoppingCart;
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
	 * @param pageNo 
	 * 	@return
	 */
	public Pagination selectByInfo(String goodsName, Integer goodsType, Integer priceMin, Integer priceMax, Integer pageNo);

	/**
	 * 	根据订单id查询商品
	 *	@author 	GFF
	 *	@date		2017年4月25日上午9:10:00	
	 * 	@param id
	 */
	public List<ShopGoods> selectShopGoodsByOderBasicId(Integer id);

	/**
	 * 	查询购物车中被选中的商品
	 *	@author 	GFF
	 *	@date		2017年4月25日下午1:39:29	
	 * 	@param key
	 * 	@return
	 */
	public List<ShopGoods> selectShopGoodsByShoppingCartIdAndGoodsIds(CustomerShoppingCart customerShoppingCart);

	/**
	 * 	查询购物车中的所有商品
	 *	@author 	GFF
	 *	@date		2017年4月25日下午2:51:38	
	 * 	@param key
	 * 	@return
	 */
	public List<ShopGoods> selectShopGoodsByShoppingCartId(Integer key);

}
