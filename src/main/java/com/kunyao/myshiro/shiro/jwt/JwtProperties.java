package com.kunyao.myshiro.shiro.jwt;

import com.kunyao.myshiro.constant.CommonConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: JwtProperties
 * @Author: kunyao
 * @Description: JWT属性配置
 * @Date: 2019/12/6 14:18
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "my-shiro.jwt")
public class JwtProperties {

    /**
     * token名称,默认名称为：token，可自定义
     */
    private String tokenName = CommonConstant.JWT_DEFAULT_TOKEN_NAME;

    /**
     * 密码
     */
    private String secret = CommonConstant.JWT_DEFAULT_SECRET;

    /**
     * 签发人
     */
    private String issuer;

    /**
     * 主题
     */
    private String subject;

    /**
     * 签发的目标
     */
    private String audience;

    /**
     * token失效时间,默认1小时，60*60=3600
     */
    private Long expireSecond = CommonConstant.JWT_DEFAULT_EXPIRE_SECOND;

    /**
     * 是否刷新token，默认为true
     */
    private boolean refreshToken = true;

    /**
     * 刷新token倒计时，默认10分钟，10*60=600
     */
    private Integer refreshTokenCountdown;

    /**
     * redis校验jwt token是否存在
     */
    private boolean redisCheck;

    /**
     * 单用户登陆，一个用户只能又一个有效的token
     */
    private boolean singleLogin;

    /**
     * 是否进行盐值校验
     */
    private boolean saltCheck;
}
