package com.pj.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleServiceImpl;
import com.pj.customer.mapper.CustomerShoppingCartMapper;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.service.CustomerShoppingCartService;
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
public class CustomerShoppingCartServiceImpl extends AbstractHandleServiceImpl<CustomerShoppingCart, Integer> implements CustomerShoppingCartService {

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
	public List<CustomerShoppingCart> selectAll() {
		List<CustomerShoppingCart> list = this.customerShoppingCartMapper.selectAll();
		for (CustomerShoppingCart customerShoppingCart : list) {
			customerShoppingCart.setShopGoods(this.shopGoodsService.selectByPrimaryKey(customerShoppingCart.getGoodsId()));
		}
		return list;
	}

	@Override
	public List<CustomerShoppingCart> selectByIds(Integer[] ids) {
		List<CustomerShoppingCart> customerShoppingCarts = new ArrayList<>();
		for (Integer id : ids) {
			CustomerShoppingCart customerShoppingCart = this.customerShoppingCartMapper.selectByPrimaryKey(id);
			customerShoppingCart.setShopGoods(this.shopGoodsService.selectByPrimaryKey(customerShoppingCart.getGoodsId()));
			customerShoppingCarts.add(customerShoppingCart);
		}
		return customerShoppingCarts;
	}
	

}
