package com.pj.order.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleTimeServiceImpl;
import com.pj.order.mapper.OrderGoodsMapper;
import com.pj.order.pojo.OrderGoods;
import com.pj.order.service.OrderGoodsService;

/**
 *	@author		GFF
 *	@date		2017年4月21日上午9:44:38
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class OrderGoodsServiceImpl extends AbstractHandleTimeServiceImpl<OrderGoods, Integer> implements OrderGoodsService {

	@Resource
	private OrderGoodsMapper orderGoodsMapper;
	
	@Override
	public MyMapper<OrderGoods> getMapper() {
		return orderGoodsMapper;
	}


}
