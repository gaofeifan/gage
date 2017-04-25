package com.pj.customer.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 *	@author		GFF
 *	@date		2017年4月25日上午10:56:34
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="customer_shoppingcart_goods_concern")
public class CustomerShoppingCartGoodsConcern implements Serializable {

	/**
	 *  购物车id
	 */
	@Column
	@ApiModelProperty(value = "购物车id", required = false)
	private Integer shopCartId;
	
	/**
	 * 	商品id
	 */
	@Column
	@ApiModelProperty(value = "商品id", required = false)
	private Integer goodsId;
	
	/**
	 * 	在购物车中添加的商品数量
	 */
	@Column
	@ApiModelProperty(value = "在购物车中添加的商品数量", required = false)
	private Integer goodsNum;

	private static final long serialVersionUID = 1L;
	
	
	public CustomerShoppingCartGoodsConcern() {}
	
	public CustomerShoppingCartGoodsConcern(Integer shopCartId, Integer goodsId) {
		super();
		this.shopCartId = shopCartId;
		this.goodsId = goodsId;
	}

	public CustomerShoppingCartGoodsConcern(Integer shopCartId, Integer goodsId, Integer goodsNum) {
		super();
		this.shopCartId = shopCartId;
		this.goodsId = goodsId;
		this.goodsNum = goodsNum;
	}

	public Integer getShopCartId() {
		return shopCartId;
	}

	public void setShopCartId(Integer shopCartId) {
		this.shopCartId = shopCartId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	
	
	
}
