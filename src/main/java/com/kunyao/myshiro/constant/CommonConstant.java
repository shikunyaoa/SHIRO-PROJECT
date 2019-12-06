package com.kunyao.myshiro.constant;

/**
 * @ClassName: CommonConstant
 * @Author: kunyao
 * @Description: 公共常量
 * @Date: 2019/12/6 14:09
 * @Version: 1.0
 */
public interface CommonConstant {

    /**
     * 登陆token
     */
    String JWT_DEFAULT_TOKEN_NAME = "token";

    /**
     * JWT用户名
     */
    String JWT_USERNAME = "username";

    /**
     * JWT刷新新token相应状态码
     */
    int JWT_REFRESH_TOKEN_CODE = 460;

    /**
     * Redis中不存在，但JWT未过期，不生成新的token
     */
    int JWT_INVALID_TOKEN_CODE = 361;

    /**
     * JWT token默认密匙
     */
    String JWT_DEFAULT_SECRET = "000000";

    /**
     * JWT 默认过期时间, 3600L 单位秒
     */
    Long JWT_DEFAULT_EXPIRE_SECOND = 3600L;

}
