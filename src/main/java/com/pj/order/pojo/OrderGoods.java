package com.pj.order.pojo;

import java.io.Serializable;
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
	private Integer order_id;

	/**
	 * 	商品id
	 */
	@Column
	@ApiModelProperty(value = "商品id", required = false)
	private Integer goods_id;
	
	/**
	 * 	商品数量
	 */
	@Column
	@ApiModelProperty(value = "商品数量", required = false)
	private Integer goods_num;
	
	/**
	 * 	商品价格
	 */
	@Column
	@ApiModelProperty(value = "商品价格", required = false)
	private Double goods_price;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public Integer getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}

	public Double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
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
		return "OrderGoods [id=" + id + ", order_id=" + order_id + ", goods_id=" + goods_id + ", goods_num=" + goods_num
				+ ", goods_price=" + goods_price + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}
	
	
	
	
}
