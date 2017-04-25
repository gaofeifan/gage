package com.pj.customer.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 用户id
	 */
	@Column
	private Integer customerId;

	/**
	 * 	购物车名称
	 */
	@Column
	@ApiModelProperty(value = "购物车名称", required = false)
	private String shoppingCartName;
	
	/**
	 * 	是否为空
	 */
	@Column
	@ApiModelProperty(value = "是否为空", required = false)
	 private Integer isEmpty;
	 
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
	private List<ShopGoods> shopGoods;
	
	@Transient
	private Integer[] goodsIds;
	
	private static final long serialVersionUID = 1L;

	public CustomerShoppingCart() {}
	
	public CustomerShoppingCart(Integer id, Integer customerId) {
		this.id = id;
		this.customerId = customerId;
	}
	public CustomerShoppingCart(Integer id, Integer customerId , Integer[] goodsIds) {
		this.id = id;
		this.customerId = customerId;
		this.goodsIds = goodsIds;
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

	public String getShoppingCartName() {
		return shoppingCartName;
	}

	public void setShoppingCartName(String shoppingCartName) {
		this.shoppingCartName = shoppingCartName;
	}

	public Integer getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(Integer isEmpty) {
		this.isEmpty = isEmpty;
	}

	public List<ShopGoods> getShopGoods() {
		return shopGoods;
	}

	public void setShopGoods(List<ShopGoods> shopGoods) {
		this.shopGoods = shopGoods;
	}

	public Integer[] getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(Integer[] goodsIds) {
		this.goodsIds = goodsIds;
	}

	
}
