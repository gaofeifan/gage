package com.pj.order.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 *	@author		GFF
 *	@date		2017年4月21日上午9:33:28
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
/**
 *
 */
@Table(name="order_goods")
public class OrderGoods implements Serializable {
	
	@Id
	@GeneratedValue(generator="JDBC")
	@ApiModelProperty(value = "创建时间", required = false)
	private Integer id;

	/**
	 * 	订单id
	 */
	@Column
	@ApiModelProperty(value = "订单id", required = false)
	private Integer orderId;

	/**
	 * 	商品id
	 */
	@Column
	@ApiModelProperty(value = "商品id", required = false)
	private Integer goodsId;
	
	/**
	 * 	商品数量
	 */
	@Column
	@ApiModelProperty(value = "商品数量", required = false)
	private Integer goodsNum;
	
	/**
	 * 	商品价格
	 */
	@Column
	@ApiModelProperty(value = "商品价格", required = false)
	private BigDecimal goodsPrice;
	
	/**
	 * 	创建时间
	 */
	@Column
	@ApiModelProperty(value = "创建时间", required = false)
	private Date createTime;
	
	/**
	 * 	更新时间
	 */
	@Column
	@ApiModelProperty(value = "更新时间", required = false)
	private Date modifyTime;
	
	private static final long serialVersionUID = 1L;
	
	public OrderGoods() {}
	
	public OrderGoods(Integer id, Integer orderId, Integer goodsId, Integer goodsNum) {
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsNum = goodsNum;
	}

	public OrderGoods(Integer id, Integer orderId, Integer goodsId, Integer goodsNum, BigDecimal goodsPrice) {
		this.id = id;
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsNum = goodsNum;
		this.goodsPrice = goodsPrice;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
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

	@Override
	public String toString() {
		return "OrderGoods [id=" + id + ", order_id=" + orderId + ", goods_id=" + goodsId + ", goods_num=" + goodsNum
				+ ", goods_price=" + goodsPrice + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}
}
