package com.pj.order.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractBaseServiceImpl;
import com.pj.order.mapper.OrderBasicMapper;
import com.pj.order.pojo.OrderBasic;
import com.pj.order.service.OrderBasicService;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午11:21:16
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class OrderBasicServiceImpl extends AbstractBaseServiceImpl<OrderBasic, Integer> implements OrderBasicService {

	@Resource
	private OrderBasicMapper orderBasicMapper;
	
	@Override
	public MyMapper<OrderBasic> getMapper() {
		return orderBasicMapper;
	}


}
