package com.pj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.mapper.MyMapper;
import com.pj.mapper.CustomerBasicMapper;
import com.pj.pojo.CustomerBasic;
import com.pj.service.CustomerBasicService;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午11:15:44
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class CustomerBasicServiceImpl extends AbstractBaseServiceImpl<CustomerBasic, Integer> implements CustomerBasicService {

	@Resource
	private CustomerBasicMapper customerBasicMapper;

	@Override
	public MyMapper<CustomerBasic> getMapper() {
		return customerBasicMapper;
	}


}
