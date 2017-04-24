package com.pj.goods.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleServiceImpl;
import com.pj.config.page.Pagination;
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
	public List<ShopGoods> selectByInfo2(String goodsName, Integer goodsType, Integer priceMin, Integer priceMax ,Integer pageNo){
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
		
		PageHelper.startPage(pageNo, 3);
		List<ShopGoods> list = shopGoodsMapper.selectAll();
		return list;
	}
	/**
	 * 	根据条件查询商品
	 */
	public Pagination selectByInfo(String goodsName, Integer goodsType, Integer priceMin, Integer priceMax ,Integer pageNo){
		ShopGoods shopGoods = new ShopGoods();
		if(StringUtils.isNotBlank(goodsName)){
			shopGoods.setGoodsName("%"+goodsName+"%");
		}
		if(goodsType != null){
			shopGoods.setGoodsType(goodsType);
		}
		if(priceMin != null){
			shopGoods.setPriceMin(priceMin);
		}
		if(priceMax != null){
			shopGoods.setPriceMax(priceMax);
		}
		shopGoods.setPageNo(Pagination.cpn(pageNo));
		shopGoods.setPageSize(10);
		
//		Page<Object> page = PageHelper.startPage(pageNo, 10);
		List<ShopGoods> list = this.shopGoodsMapper.selectByInfo(shopGoods);
		Integer totalCount = this.shopGoodsMapper.selectByInfoCount(shopGoods);
		Pagination pagination = new Pagination(shopGoods.getPageNo(), shopGoods.getPageSize(), totalCount, list);
		return pagination;
	}
	
}
