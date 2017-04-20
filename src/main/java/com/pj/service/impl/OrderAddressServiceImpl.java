package com.pj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.mapper.OrderAddressMapper;import com.pj.config.mapper.MyMapper;
import com.pj.pojo.OrderAddress;
import com.pj.service.OrderAddressService;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午11:17:21
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class OrderAddressServiceImpl extends AbstractBaseServiceImpl<OrderAddress, Integer> implements OrderAddressService {

	@Resource
	private OrderAddressMapper orderAddressMapper;
	
	@Override
	public MyMapper<OrderAddress> getMapper() {
		return orderAddressMapper;
	}


}
