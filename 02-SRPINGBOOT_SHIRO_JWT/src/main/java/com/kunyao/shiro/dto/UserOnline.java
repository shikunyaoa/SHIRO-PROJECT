package com.kunyao.shiro.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserOnline
 * @Author: kunyao
 * @Description: 描述在线用户信息
 * @Date: 2020/3/21 11:05
 * @Version: 1.0
 */
@Data
public class UserOnline implements Serializable {

    private static final long serialVersionUID = 3828664348416633856L;
    // session id
    private String id;
    // 用户id
    private String userId;
    // 用户名称
    private String username;
    // 用户主机地址
    private String host;
    // 用户登录时系统IP
    private String systemHost;
    // 状态
    private String status;
    // session创建时间
    private Date startTimestamp;
    // session最后访问时间
    private Date lastAccessTime;
    // 超时时间
    private Long timeout;

}