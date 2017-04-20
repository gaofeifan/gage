package com.pj.order.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;


@Table(name="order_basic")
public class OrderBasic implements Serializable {
    @Id
    @ApiModelProperty(value = "id", required = false)
	private Integer id;

    /**
     * 订单号
     */
    @Column
    @ApiModelProperty(value = "订单号", required = false)
    private String orderNo;

    @Column
    @ApiModelProperty(value = "customerId", required = false)
    private Integer customerId;

    /**
     * 订单状态(1：订单创建;）
     */
    @Column
    @ApiModelProperty(value = "订单状态(1：订单创建;）", required = false)
    private Integer orderStatus;

    /**
     * 订单是否导出（0：否；1：是）
     */
    @Column
    @ApiModelProperty(value = "订单是否导出（0：否；1：是）", required = false)
    private Integer isImport;

    /**
     * 商品id
     */
    @Column
    @ApiModelProperty(value = "商品id", required = false)
    private Integer goodsId;

    /**
     * 订单中商品的数量
     */
    @Column
    @ApiModelProperty(value = "订单中商品的数量", required = false)
    private Integer goodsNum;

    /**
     * 订单创建时间
     */
    @Column
    @ApiModelProperty(value = "订单创建时间", required = false)
    private Date createTime;

    @Column
    @ApiModelProperty(value = "订单修改时间", required = false)
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getIsImport() {
        return isImport;
    }

    public void setIsImport(Integer isImport) {
        this.isImport = isImport;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", customerId=").append(customerId);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", isImport=").append(isImport);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}