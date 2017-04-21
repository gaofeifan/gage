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
 *	@date		2017年4月20日上午10:44:44
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Table(name="order_address")
public class OrderAddress implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 *	id 	
	 */
	@Id
	@GeneratedValue(generator = "JDBC")
	@ApiModelProperty(value = "id", required = false)
	private Integer id;
	
	/**
	 * 	收件人姓名
	 */
	@Column
	@ApiModelProperty(value = "收件人姓名", required = false)
	private String name;
	
	/**
	 * 	收件人手机号
	 */
	@Column
	@ApiModelProperty(value = "收件人手机号", required = false)
	private String phone;
	
	/**
	 * 	地址描述
	 */
	@Column
	@ApiModelProperty(value = "地址描述", required = false)
	private String addressDesc;
	
	/**
	 * 	备注
	 */
	@Column
	@ApiModelProperty(value = "备注", required = false)
	private String remark;
	
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

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddressDesc() {
		return addressDesc;
	}



	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
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
		return "OrderAddress [id=" + id + ", name=" + name + ", phone=" + phone + ", addressDesc=" + addressDesc
				+ ", remark=" + remark + "]";
	}
	
	
}
