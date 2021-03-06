package com.pj.goods.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "shop_goods")
public class ShopGoods implements Serializable {
	@Id
	@ApiModelProperty(value = "id", required = false)
	private Integer id;

	/**
	 * 商品名称
	 */
	@Column
	@ApiModelProperty(value = "商品名称", required = false)
	private String goodsName;

	/**
	 * 商品图片展示路劲
	 */
	@Column
	@ApiModelProperty(value = "商品图片展示路劲", required = false)
	private String goodsImageUrl;

	/**
	 * 商品数量
	 */
	@Column
	@ApiModelProperty(value = "商品数量", required = false)
	private Integer goodsTotalNum;

	/**
	 * 商品类型
	 */
	@Column
	@ApiModelProperty(value = "商品类型", required = false)
	private Integer goodsType;

	/**
	 * 商品条形码
	 */
	@Column
	@ApiModelProperty(value = "商品条形码", required = false)
	private String goodsBarcode;

	/**
	 * 商品原价
	 */
	@Column
	@ApiModelProperty(value = "商品原价", required = false)
	private BigDecimal goodsOriginalCost;

	/**
	 * 商品现价
	 */
	@Column
	@ApiModelProperty(value = "商品现价", required = false)
	private BigDecimal goodsCurrentPrice;

	/**
	 * 商品详情
	 */
	@Column
	@ApiModelProperty(value = "商品详情", required = false)
	private String goodsDetails;

	/**
	 * 商品创建时间
	 */
	@Column
	@ApiModelProperty(value = "商品创建时间", required = false)
	private Date createTime;

	/**
	 * 商品修改时间
	 */
	@Column
	@ApiModelProperty(value = "商品修改时间", required = false)
	private Date modifyTime;

	/**
	 * 最低价(条件查询)
	 */
	@Transient
	@ApiModelProperty(value = "最低价", required = false)
	private Integer priceMin;

	/**
	 * 最高价(条件查询)
	 */
	@Transient
	@ApiModelProperty(value = "最高价", required = false)
	private Integer priceMax;

	/**
	 * 	商品购买的数量(返回给页面展示)
	 */
	@Transient
	private Integer goodsNum;
	
	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsImageUrl() {
		return goodsImageUrl;
	}

	public void setGoodsImageUrl(String goodsImageUrl) {
		this.goodsImageUrl = goodsImageUrl;
	}

	public Integer getGoodsTotalNum() {
		return goodsTotalNum;
	}

	public void setGoodsTotalNum(Integer goodsTotalNum) {
		this.goodsTotalNum = goodsTotalNum;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsBarcode() {
		return goodsBarcode;
	}

	public void setGoodsBarcode(String goodsBarcode) {
		this.goodsBarcode = goodsBarcode;
	}

	public BigDecimal getGoodsOriginalCost() {
		return goodsOriginalCost;
	}

	public void setGoodsOriginalCost(BigDecimal goodsOriginalCost) {
		this.goodsOriginalCost = goodsOriginalCost;
	}

	public BigDecimal getGoodsCurrentPrice() {
		return goodsCurrentPrice;
	}

	public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
		this.goodsCurrentPrice = goodsCurrentPrice;
	}

	public String getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(String goodsDetails) {
		this.goodsDetails = goodsDetails;
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

	public Integer getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}

	public Integer getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Integer priceMax) {
		this.priceMax = priceMax;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	@Override
	public String toString() {
		return "ShopGoods [id=" + id + ", goodsName=" + goodsName + ", goodsImageUrl=" + goodsImageUrl
				+ ", goodsTotalNum=" + goodsTotalNum + ", goodsType=" + goodsType + ", goodsBarcode=" + goodsBarcode
				+ ", goodsOriginalCost=" + goodsOriginalCost + ", goodsCurrentPrice=" + goodsCurrentPrice
				+ ", goodsDetails=" + goodsDetails + ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ ", priceMin=" + priceMin + ", priceMax=" + priceMax + "]";
	}

}