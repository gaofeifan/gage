package com.pj.customer.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModelProperty;
@Table(name="customer_basic")
public class CustomerBasic implements Serializable {
	@Id
	@ApiModelProperty(value = "id", required = false)
    private Integer id;

    /**
     * 注册用户姓名
     */
	@Column
	@ApiModelProperty(value = "注册用户姓名", required = false)
    private String name;

    /**
     * 性别
     */
    @Column
    @ApiModelProperty(value = "性别", required = false)
    private String sex;

    @Column
    @ApiModelProperty(value = "电话", required = false)
    private String phone;

    /**
     * 用户名
     */
    @Column
    @ApiModelProperty(value = "用户名", required = false)
    private String username;

    /**
     * 密码
     */
    @Column
    @ApiModelProperty(value = "密码", required = false)
    private String password;

    /**
     * 邮箱
     */
    @Column
    @ApiModelProperty(value = "邮箱", required = false)
    private String email;

    @Column
    @ApiModelProperty(value = "角色id", required = false)
    private Integer userRoleId;

    /**
     * 是否启用（0：是；1否）
     */
    @Column
    @ApiModelProperty(value = "是否启用（0：是；1否）", required = false)
    private String flag;

    private static final long serialVersionUID = 1L;

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
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", userRoleId=").append(userRoleId);
        sb.append(", flag=").append(flag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}