package com.kunyao.shiro.chapter2_Authentication.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @ClassName: MyRealm1
 * @Author: kunyao
 * @Description: 自定义Realm2
 * @Date: 2020/3/6 9:59
 * @Version: 1.0
 */
public class MyRealm2 implements Realm {

    @Override
    public String getName() {
        return "myrealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到用户名
        String username = (String)authenticationToken.getPrincipal();
        //得到密码
        String password = new String((char[])authenticationToken.getCredentials());
        if(!"zhang".equals(username)){
            //如果用户名错误抛出异常
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)){
            //如果密码错误
            throw new IncorrectCredentialsException();
        }
        //如果身份认证验证成功，返回一个Authentication实现
        return new SimpleAuthenticationInfo("zhang@163.com", password, getName());
    }
}
