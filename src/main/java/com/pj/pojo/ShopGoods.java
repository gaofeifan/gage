package com.pj.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
@Table(name="shop_goods")
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
    private Double goodsOriginalCost;

    /**
     * 商品现价
     */
    @Column
    @ApiModelProperty(value = "商品现价", required = false)
    private Double goodsCurrentPrice;

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
    private Date goodsCreateTime;

    /**
     * 商品修改时间
     */
    @Column
    @ApiModelProperty(value = "商品修改时间", required = false)
    private Date goodsModifyTime;

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

    public Double getGoodsOriginalCost() {
        return goodsOriginalCost;
    }

    public void setGoodsOriginalCost(Double goodsOriginalCost) {
        this.goodsOriginalCost = goodsOriginalCost;
    }

    public Double getGoodsCurrentPrice() {
        return goodsCurrentPrice;
    }

    public void setGoodsCurrentPrice(Double goodsCurrentPrice) {
        this.goodsCurrentPrice = goodsCurrentPrice;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public Date getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(Date goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }

    public Date getGoodsModifyTime() {
        return goodsModifyTime;
    }

    public void setGoodsModifyTime(Date goodsModifyTime) {
        this.goodsModifyTime = goodsModifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsImageUrl=").append(goodsImageUrl);
        sb.append(", goodsTotalNum=").append(goodsTotalNum);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", goodsBarcode=").append(goodsBarcode);
        sb.append(", goodsOriginalCost=").append(goodsOriginalCost);
        sb.append(", goodsCurrentPrice=").append(goodsCurrentPrice);
        sb.append(", goodsDetails=").append(goodsDetails);
        sb.append(", goodsCreateTime=").append(goodsCreateTime);
        sb.append(", goodsModifyTime=").append(goodsModifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}