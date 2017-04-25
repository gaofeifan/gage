package com.pj.order.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleTimeServiceImpl;
import com.pj.order.mapper.OrderAddressMapper;
import com.pj.order.pojo.OrderAddress;
import com.pj.order.service.OrderAddressService;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午11:17:21
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class OrderAddressServiceImpl extends AbstractHandleTimeServiceImpl<OrderAddress, Integer> implements OrderAddressService {

	@Resource
	private OrderAddressMapper orderAddressMapper;
	
	@Override
	public MyMapper<OrderAddress> getMapper() {
		return orderAddressMapper;
	}


}
