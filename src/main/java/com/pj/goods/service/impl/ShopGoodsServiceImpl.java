package com.pj.goods.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pj.config.base.MyMapper;
import com.pj.config.base.impl.AbstractHandleTimeServiceImpl;
import com.pj.config.page.Pagination;
import com.pj.customer.pojo.CustomerShoppingCart;
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
public class ShopGoodsServiceImpl extends AbstractHandleTimeServiceImpl<ShopGoods, Integer> implements ShopGoodsService {

	@Resource
	private ShopGoodsMapper shopGoodsMapper;
	
	@Override
	public MyMapper<ShopGoods> getMapper() {
		return shopGoodsMapper;
	}

	/**
	 * 	根据条件查询商品
	 */
	public Pagination selectByInfo(String goodsName, Integer goodsType, Integer priceMin, Integer priceMax ,Integer pageNo){
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
		/**
		 * 	start
		 * 	TODO 暂时由后台处理当前页码超出总页数的判断
		 */
		List<ShopGoods> list = this.shopGoodsMapper.selectByExample(example);
		int totalPage = getTotalPage(list.size(), 12);
		/**
		 * 	end
		 */
		Page<Object> page = PageHelper.startPage(Pagination.cpn(pageNo > totalPage ? totalPage : pageNo), 12);
		List<ShopGoods> shopGoods = this.shopGoodsMapper.selectByExample(example);
		return new Pagination(page.getPageNum(), page.getPageSize(), (int) page.getTotal(), shopGoods);
	}

	@Override
	public List<ShopGoods> selectShopGoodsByOderBasicId(Integer id) {
		return this.shopGoodsMapper.selectShopGoodsByOderBasicId(id);
	}
	
	/**
	 * 	求出总页数
	 *	@author 	GFF
	 *	@date		2017年4月25日上午10:19:02	
	 * 	@param totalCount
	 * 	@param pageSize
	 * 	@return
	 */
	private int getTotalPage(int totalCount , int pageSize) {
		int totalPage = totalCount / pageSize;
		if (totalPage == 0 || totalCount % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	/**
	 * 	查询购物车中的商品
	 */
	@Override
	public List<ShopGoods> selectShopGoodsByShoppingCartIdAndGoodsIds(CustomerShoppingCart customerShoppingCart) {
		return this.shopGoodsMapper.selectShopGoodsByShoppingCartIdAndGoodsIds(customerShoppingCart);
	}

	/**
	 * 	查询购物车中的所有商品
	 */
	@Override
	public List<ShopGoods> selectShopGoodsByShoppingCartId(Integer key) {
		return this.shopGoodsMapper.selectShopGoodsByShoppingCartId(key);
	}
	
}
