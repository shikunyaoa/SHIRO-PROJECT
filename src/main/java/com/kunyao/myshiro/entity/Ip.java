package com.kunyao.myshiro.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * IP地址
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
public class Ip extends Model<Ip> {

    private static final long serialVersionUID = 1L;

    @TableField("ip_start")
    private String ipStart;
    @TableField("ip_end")
    private String ipEnd;
    private String area;
    private String operator;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("ip_start_num")
    private Long ipStartNum;
    @TableField("ip_end_num")
    private Long ipEndNum;


    public String getIpStart() {
        return ipStart;
    }

    public void setIpStart(String ipStart) {
        this.ipStart = ipStart;
    }

    public String getIpEnd() {
        return ipEnd;
    }

    public void setIpEnd(String ipEnd) {
        this.ipEnd = ipEnd;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIpStartNum() {
        return ipStartNum;
    }

    public void setIpStartNum(Long ipStartNum) {
        this.ipStartNum = ipStartNum;
    }

    public Long getIpEndNum() {
        return ipEndNum;
    }

    public void setIpEndNum(Long ipEndNum) {
        this.ipEndNum = ipEndNum;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Ip{" +
        "ipStart=" + ipStart +
        ", ipEnd=" + ipEnd +
        ", area=" + area +
        ", operator=" + operator +
        ", id=" + id +
        ", ipStartNum=" + ipStartNum +
        ", ipEndNum=" + ipEndNum +
        "}";
    }
}
