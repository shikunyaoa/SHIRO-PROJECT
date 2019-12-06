package com.kunyao.myshiro.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统权限
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@TableName("sys_permission")
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 父id
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 路径
     */
    private String url;
    /**
     * 唯一编码
     */
    private String code;
    /**
     * 图标
     */
    private String icon;
    /**
     * 类型，1：菜单，2：按钮
     */
    private Integer type;
    /**
     * 层级，1：第一级，2：第二级，N：第N级
     */
    private Integer level;
    /**
     * 状态，0：禁用，1：启用
     */
    private Integer state;
    /**
     * 排序
     */
    private Integer sort;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        return "Permission{" +
        "id=" + id +
        ", name=" + name +
        ", parentId=" + parentId +
        ", url=" + url +
        ", code=" + code +
        ", icon=" + icon +
        ", type=" + type +
        ", level=" + level +
        ", state=" + state +
        ", sort=" + sort +
        ", remark=" + remark +
        ", version=" + version +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
