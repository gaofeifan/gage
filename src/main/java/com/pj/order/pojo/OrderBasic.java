package com.pj.order.pojo;

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


@Table(name="order_basic")
public class OrderBasic implements Serializable {
    @Id
    @ApiModelProperty(value = "id", required = false)
    @GeneratedValue(generator = "JDBC")
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
     * 	订单地址
     */
    @Column
    @ApiModelProperty(value = "订单地址", required = false)
    private Integer orderAddressId;
   
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

    @Transient
    @ApiModelProperty(value = "商品id", required = false)
    private Integer[] shopGoodsIds;
    
    @Transient
    private List<ShopGoods> shopGoods;
    
    @Transient
    private OrderAddress orderAddress;

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

	public Integer[] getShopGoodsIds() {
		return shopGoodsIds;
	}

	public void setShopGoodsIds(Integer[] shopGoodsIds) {
		this.shopGoodsIds = shopGoodsIds;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public List<ShopGoods> getShopGoods() {
		return shopGoods;
	}

	public void setShopGoods(List<ShopGoods> shopGoods) {
		this.shopGoods = shopGoods;
	}
	
	public Integer getOrderAddressId() {
		return orderAddressId;
	}

	public void setOrderAddressId(Integer orderAddressId) {
		this.orderAddressId = orderAddressId;
	}

	public OrderAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrderAddress orderAddress) {
		this.orderAddress = orderAddress;
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
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}