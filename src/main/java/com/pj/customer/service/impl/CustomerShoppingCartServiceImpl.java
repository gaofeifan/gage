package com.pj.customer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleTimeServiceImpl;
import com.pj.customer.mapper.CustomerShoppingCartMapper;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.service.CustomerShoppingCartService;
import com.pj.goods.pojo.ShopGoods;
import com.pj.goods.service.ShopGoodsService;

/**
 *	@author		GFF
 *	@date		2017年4月21日上午9:42:11
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class CustomerShoppingCartServiceImpl extends AbstractHandleTimeServiceImpl<CustomerShoppingCart, Integer> implements CustomerShoppingCartService {

	@Resource
	private CustomerShoppingCartMapper customerShoppingCartMapper;
	
	@Resource
	private ShopGoodsService shopGoodsService;
	
	@Override
	public MyMapper<CustomerShoppingCart> getMapper() {
		return customerShoppingCartMapper;
	}


	/**
	 * 	查询购物车中的商品
	 */
	@Override
	public CustomerShoppingCart selectByPrimaryKey(Integer key) {
		CustomerShoppingCart shoppingCart = customerShoppingCartMapper.selectByPrimaryKey(key);
		List<ShopGoods> shopGoods = this.shopGoodsService.selectShopGoodsByShoppingCartId(key);
		shoppingCart.setShopGoods(shopGoods);
		return shoppingCart;
	}

	/**
	 * 	查询购物车中被选中的商品
	 */
	@Override
	public CustomerShoppingCart selectByShoppingCartAndGoodsIds(int cartId, Integer[] ids) {
		CustomerShoppingCart customerShoppingCart = this.customerShoppingCartMapper.selectByPrimaryKey(cartId);
		List<ShopGoods> shopGoods = this.shopGoodsService.selectShopGoodsByShoppingCartIdAndGoodsIds(new CustomerShoppingCart(cartId, null,ids));
		customerShoppingCart.setShopGoods(shopGoods);
		return customerShoppingCart;
	}


}
