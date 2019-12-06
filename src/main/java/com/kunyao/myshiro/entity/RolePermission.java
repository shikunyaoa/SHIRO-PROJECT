package com.kunyao.myshiro.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色权限关系
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@TableName("sys_role_permission")
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 角色id
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 权限id
     */
    @TableField("permission_id")
    private Long permissionId;
    /**
     * 状态，0：禁用，1：启用
     */
    private Integer state;
    /**
     * 备注
     */
    private String remark;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        ", state=" + state +
        ", remark=" + remark +
        ", version=" + version +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
