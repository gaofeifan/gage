package com.pj.customer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractBaseServiceImpl;
import com.pj.customer.mapper.CustomerShoppingCartGoodsConcernMapper;
import com.pj.customer.mapper.CustomerShoppingCartMapper;
import com.pj.customer.pojo.CustomerShoppingCart;
import com.pj.customer.pojo.CustomerShoppingCartGoodsConcern;
import com.pj.customer.service.CustomerShoppingCartGoodsConcernService;

import tk.mybatis.mapper.entity.Example;

/**
 *	@author		GFF
 *	@date		2017年4月25日上午11:05:59
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Service
@Transactional
public class CustomerShoppingCartGoodsConcernServiceImpl extends AbstractBaseServiceImpl<CustomerShoppingCartGoodsConcern, Integer>
		implements CustomerShoppingCartGoodsConcernService {

	@Resource
	private CustomerShoppingCartGoodsConcernMapper customerShoppingCartGoodsConcernMapper;
	
	@Resource
	private CustomerShoppingCartMapper customerShoppingCartMapper;
	
	@Override
	public MyMapper<CustomerShoppingCartGoodsConcern> getMapper() {
		return customerShoppingCartGoodsConcernMapper;
	}

	/**
	 * 	添加购物车中的商品
	 */
	@Override
	public int insertSelective(CustomerShoppingCartGoodsConcern t) {
		List<CustomerShoppingCartGoodsConcern> list = this.select(new CustomerShoppingCartGoodsConcern(t.getShopCartId(), t.getGoodsId()));
		if(list.size() != 0){
			CustomerShoppingCartGoodsConcern goodsConcern = list.get(0);
			goodsConcern.setGoodsNum(t.getGoodsNum() + goodsConcern.getGoodsNum());
			return this.updateByPrimaryKeySelective(goodsConcern);
		}
		super.insertSelective(t);
		return this.customerShoppingCartMapper.updateByPrimaryKeySelective(new CustomerShoppingCart(t.getShopCartId(), null, 1));
	}

	/**
	 * 	更新购物车中的数量
	 */
	@Override
	public int updateByPrimaryKeySelective(CustomerShoppingCartGoodsConcern record) {
		Example example = new Example(CustomerShoppingCartGoodsConcern.class);
		example.createCriteria().andCondition("shop_cart_id =", record.getShopCartId()).andCondition("goods_id=", record.getGoodsId());
		return this.customerShoppingCartGoodsConcernMapper.updateByExampleSelective(record, example);
	}

	

}
