package com.pj.customer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractBaseServiceImpl;
import com.pj.customer.mapper.CustomerShoppingCartMapper;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.service.CustomerShoppingCartService;

/**
 *	@author		GFF
 *	@date		2017年4月21日上午9:42:11
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class CustomerShoppingCartServiceImpl extends AbstractBaseServiceImpl<CustomerShoppingCart, Integer> implements CustomerShoppingCartService {

	@Resource
	private CustomerShoppingCartMapper customerShoppingCartMapper;
	
	@Override
	public MyMapper<CustomerShoppingCart> getMapper() {
		return customerShoppingCartMapper;
	}


}
