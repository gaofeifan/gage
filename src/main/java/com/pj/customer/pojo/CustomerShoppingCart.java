package com.pj.customer.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.pj.goods.pojo.ShopGoods;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author GFF
 * @date 2017年4月21日上午9:08:04
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
@Table(name = "customer_shopping_cart")
public class CustomerShoppingCart implements Serializable {

	@Id
	private Integer id;

	/**
	 * 用户id
	 */
	@Column
	private Integer customerId;

	/**
	 * 商品id
	 */
	@Column
	private Integer goodsId;

	/**
	 * 商品数量
	 */
	@Column
	private Integer goodsNum;

	/**
	 * 创建时间
	 */
	@Column
	@ApiModelProperty(value = "创建时间", required = false)
	private Date createTime;

	/**
	 * 更新时间
	 */
	@Column
	@ApiModelProperty(value = "更新时间", required = false)
	private Date modifyTime;

	/**
	 * 	商品
	 */
	@Transient
	private ShopGoods shopGoods;
	
	private static final long serialVersionUID = 1L;

	public CustomerShoppingCart() {}
	
	public CustomerShoppingCart(Integer customerId, Integer goodsId, Integer goodsNum) {
		super();
		this.customerId = customerId;
		this.goodsId = goodsId;
		this.goodsNum = goodsNum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public ShopGoods getShopGoods() {
		return shopGoods;
	}

	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}

}
