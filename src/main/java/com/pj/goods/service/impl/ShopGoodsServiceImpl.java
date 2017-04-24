package com.pj.goods.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleServiceImpl;
import com.pj.goods.mapper.ShopGoodsMapper;
import com.pj.goods.pojo.ShopGoods;
import com.pj.goods.service.ShopGoodsService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 *	@author		GFF
 *	@date		2017年4月20日上午11:20:39
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class ShopGoodsServiceImpl extends AbstractHandleServiceImpl<ShopGoods, Integer> implements ShopGoodsService {

	@Resource
	private ShopGoodsMapper shopGoodsMapper;
	
	@Override
	public MyMapper<ShopGoods> getMapper() {
		return shopGoodsMapper;
	}

	/**
	 * 	根据条件查询商品
	 */
	public List<ShopGoods> selectByInfo(String goodsName, Integer goodsType, Integer priceMin, Integer priceMax){
		Example example = new Example(ShopGoods.class);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(goodsName)){
			criteria.andLike("goodsName", "%"+goodsName+"%");
		}
		if(goodsType != null){
			criteria.andEqualTo("goodsType", goodsType);
		}
		if(priceMin != null){
			criteria.andGreaterThanOrEqualTo("goodsCurrentPrice", priceMin);
		}
		if(priceMax != null){
			criteria.andLessThanOrEqualTo("goodsCurrentPrice", priceMax);
		}
		example.orderBy("goodsCreateTime").desc();
		return this.shopGoodsMapper.selectByExample(example);
	}
	
}
