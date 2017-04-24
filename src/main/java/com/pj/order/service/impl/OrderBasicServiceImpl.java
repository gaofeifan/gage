package com.pj.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleServiceImpl;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.service.CustomerShoppingCartService;
import com.pj.order.mapper.OrderBasicMapper;
import com.pj.order.pojo.OrderBasic;
import com.pj.order.pojo.OrderGoods;
import com.pj.order.service.OrderBasicService;
import com.pj.order.service.OrderGoodsService;
import com.pj.utils.RandomID;

/**
 * @author GFF
 * @date 2017年4月20日上午11:21:16
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
@Service
@Transactional
public class OrderBasicServiceImpl extends AbstractHandleServiceImpl<OrderBasic, Integer> implements OrderBasicService {

	@Resource
	private OrderBasicMapper orderBasicMapper;

	@Resource 
	private OrderGoodsService orderGoodsService; 
	
	@Resource
	private CustomerShoppingCartService customerShoppingCartService;
	
	@Override
	public MyMapper<OrderBasic> getMapper() {
		return orderBasicMapper;
	}

	/**
	 * 	保存订单
	 */
	@Override
	public int insertSelective(OrderBasic orderBasic) {
		//	设置订单编号
		orderBasic.setOrderNo(new RandomID().GenTradeId());
		int i = this.orderBasicMapper.insertSelective(orderBasic);
		//	获取购物车中北被选中的商品
		List<CustomerShoppingCart> shoppingCarts = this.customerShoppingCartService.selectByIds(orderBasic.getShoppingCarts());
		for (CustomerShoppingCart customerShoppingCart : shoppingCarts) {
			this.orderGoodsService.insertSelective(new OrderGoods(null, orderBasic.getId(), customerShoppingCart.getGoodsId(), customerShoppingCart.getGoodsNum()));
		}
		return i;
	}

}
