package com.kunyao.myshiro.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统日志
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@TableName("sys_log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("log_id")
    private Long logId;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建人ID
     */
    @TableField("create_id")
    private Long createId;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.logId;
    }

    @Override
    public String toString() {
        return "Log{" +
        "logId=" + logId +
        ", type=" + type +
        ", content=" + content +
        ", createId=" + createId +
        ", createTime=" + createTime +
        "}";
    }
}
