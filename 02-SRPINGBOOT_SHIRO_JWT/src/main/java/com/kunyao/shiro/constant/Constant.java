package com.kunyao.shiro.constant;

/**
 * @ClassName: Constant
 * @Author: kunyao
 * @Description: 常量类
 * @Date: 2019/12/12 9:33
 * @Version: 1.0
 */
public class Constant {

    //用户名登录
    public static final int LOGIN_USERNAME = 0;
    //手机号登录
    public static final int LOGIN_MOBILE = 1;

    //超级管理员id
    public static final int ADMIN_ID = 11;

    public static final int ROLEID = 3;
    //启用
    public static final int ENABLE = 1;
    //禁用
    public static final int DISABLE = 2;
    //锁定
    public static final int LOCKED = 3;

    public static Boolean isPass = true;

    //验证码过期时间
    public static final Long PASS_TIME = 360 * 1000L;

    public class RoleType{

        public static final int GOLD = 3;

        public static final int WHITE = 2;

        public static final int GENERAL = 1;
    }
}
