package com.kunyao.shiro.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName: JWTUtil
 * @Author: kunyao
 * @Description: JWT工具类
 * @Date: 2019/12/12 13:13
 * @Version: 1.0
 */
public class JWTUtil {


    private static final long EXPIRE_TIME =  24 * 60 * 60 * 1000;

    /**
     * 生成签名，指定时间后过期
     * @param userNo
     * @param secret
     * @return
     */
    public static String sign(String userNo, String secret){
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("userNo", userNo )
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验token是否正确
     * @param token
     * @param userNo
     * @param secret
     * @return
     */
    public static boolean verify(String token, String userNo, String secret){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withClaim("userNo", userNo)
                    .build();
            jwtVerifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取token中的信息无需secret解密也能获得
     * @param token
     * @return
     */
    public static String getUserNo(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userNo").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取过期时间
     * @param token
     * @return
     */
    public static Date getExpireDate(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getExpiresAt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 判断token是否过期
    * @param token
     * @return
     */
    public static boolean isExpired(String token){
        Date expireDate = getExpireDate(token);
        if(expireDate == null){
            return true;
        }
        return expireDate.before(new Date());
    }

    /**
     * 刷新token的过期时间
     * @param token
     * @param secret
     * @return
     */
    public static String RefreshTokenExpired(String token, String secret){

        DecodedJWT jwt = JWT.decode(token);
        Map<String, Claim> claims = jwt.getClaims();
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Builder builder = JWT.create().withExpiresAt(date);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            for (Map.Entry<String, Claim> entry: claims.entrySet()
                 ) {
                builder.withClaim(entry.getKey(), entry.getValue().asString());
            }
            return builder.sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }
}
