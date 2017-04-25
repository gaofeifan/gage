package com.pj.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleTimeServiceImpl;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.service.CustomerShoppingCartService;
import com.pj.goods.pojo.ShopGoods;
import com.pj.goods.service.ShopGoodsService;
import com.pj.order.mapper.OrderBasicMapper;
import com.pj.order.pojo.OrderAddress;
import com.pj.order.pojo.OrderBasic;
import com.pj.order.pojo.OrderGoods;
import com.pj.order.service.OrderAddressService;
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
public class OrderBasicServiceImpl extends AbstractHandleTimeServiceImpl<OrderBasic, Integer> implements OrderBasicService {

	@Resource
	private OrderBasicMapper orderBasicMapper;

	@Resource 
	private OrderGoodsService orderGoodsService; 
	
	@Resource
	private ShopGoodsService shopGoodsService;
	
	@Resource
	private CustomerShoppingCartService customerShoppingCartService;
	
	@Resource
	private OrderAddressService orderAddressService;
	
	@Override
	public MyMapper<OrderBasic> getMapper() {
		return orderBasicMapper;
	}

	/**
	 * 	查询订单详情
	 */
	@Override
	public OrderBasic selectOrderById(Integer orderId) {
		OrderBasic orderBasic = this.orderBasicMapper.selectByPrimaryKey(orderId);
		List<ShopGoods> shopGoods = this.shopGoodsService.selectShopGoodsByOderBasicId(orderBasic.getId());
		orderBasic.setShopGoods(shopGoods);
		OrderAddress orderAddress = this.orderAddressService.selectByPrimaryKey(orderBasic.getOrderAddressId());
		orderBasic.setOrderAddress(orderAddress);
		return orderBasic;
	}
	
	/**
	 * 	添加订单
	 */
	@Override
	public void insertSelective(OrderBasic orderBasic, int cartId) {
		// 设置订单编号
		orderBasic.setOrderNo(new RandomID().GenTradeId());
		this.orderBasicMapper.insertSelective(orderBasic);
		List<ShopGoods> shopGoodss = this.shopGoodsService.selectShopGoodsByShoppingCartIdAndGoodsIds(new CustomerShoppingCart(cartId, null, orderBasic.getShopGoodsIds()));
		for (ShopGoods shopGoods : shopGoodss) {
			this.orderGoodsService.insertSelective(new OrderGoods(null, orderBasic.getId(), shopGoods.getId(), shopGoods.getGoodsNum()));
		}
		this.customerShoppingCartService.delete(new CustomerShoppingCart());
	}

}

 