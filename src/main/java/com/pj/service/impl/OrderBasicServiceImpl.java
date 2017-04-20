package com.pj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.mapper.MyMapper;
import com.pj.mapper.OrderBasicMapper;
import com.pj.pojo.OrderBasic;
import com.pj.service.OrderBasicService;

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
