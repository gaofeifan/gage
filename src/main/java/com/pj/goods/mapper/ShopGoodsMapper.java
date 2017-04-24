package com.pj.goods.mapper;

import java.util.List;

import com.pj.config.base.MyMapper;
import com.pj.goods.pojo.ShopGoods;

public interface ShopGoodsMapper extends MyMapper<ShopGoods> {

	List<ShopGoods> selectByInfo(ShopGoods shopGoods);

	Integer selectByInfoCount(ShopGoods shopGoods);
}