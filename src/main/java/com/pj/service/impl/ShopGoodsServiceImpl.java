package com.pj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.mapper.MyMapper;
import com.pj.mapper.ShopGoodsMapper;
import com.pj.pojo.ShopGoods;
import com.pj.service.ShopGoodsService;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午11:20:39
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class ShopGoodsServiceImpl extends AbstractBaseServiceImpl<ShopGoods, Integer> implements ShopGoodsService {

	@Resource
	private ShopGoodsMapper shopGoodsMapper;
	
	@Override
	public MyMapper<ShopGoods> getMapper() {
		return null;
	}


}
