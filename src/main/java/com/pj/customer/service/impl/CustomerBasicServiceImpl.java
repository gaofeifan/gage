package com.pj.customer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleTimeServiceImpl;
import com.pj.customer.mapper.CustomerBasicMapper;
import com.pj.customer.pojo.CustomerBasic;
import com.pj.customer.service.CustomerBasicService;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午11:15:44
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class CustomerBasicServiceImpl extends AbstractHandleTimeServiceImpl<CustomerBasic, Integer> implements CustomerBasicService {

	@Resource
	private CustomerBasicMapper customerBasicMapper;

	@Override
	public MyMapper<CustomerBasic> getMapper() {
		return customerBasicMapper;
	}


}
