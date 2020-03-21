package com.kunyao.shiro.shiro;


import com.kunyao.shiro.config.SpringContextBeanService;
import com.kunyao.shiro.service.UserService;
import com.kunyao.shiro.utils.JWTUtil;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: JwtMatcher
 * @Author: kunyao
 * @Description:
 * @Date: 2019/12/16 10:16
 * @Version: 1.0
 */
@Component
public class JwtMatcher implements CredentialsMatcher {

    @Autowired
    private UserService userService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        if(userService == null){
            this.userService = SpringContextBeanService.getBean(UserService.class);
        }
        String token = (String) authenticationInfo.getCredentials();
        String userNo = null;
        try {
            userNo = JWTUtil.getUserNo(token);
        } catch (SignatureException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
            throw new AuthenticationException("errJwt");
        }catch (Exception e){
            throw new AuthenticationException("errJwt");
        }
        if( userNo == null){
            throw new AuthenticationException("errJwt");
        }
        if(JWTUtil.isExpired(token)){
            throw new AuthenticationException("expiredJwt");
        }
        return true;
    }
}
