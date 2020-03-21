package com.kunyao.shiro.chapter2_Authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: TestHelloworld
 * @Author: kunyao
 * @Description: 基于ini文件的身份认证
 * @Date: 2020/3/5 21:06
 * @Version: 1.0
 */
public class TestHelloworld {

    @Test
    public void testHelloworld(){

        //基于配置文件创建factory
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        //创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //绑定到SecurityUtils,这是一个全局设置
        SecurityUtils.setSecurityManager(securityManager);
        //通过SecurityUtils得到subject
        Subject subject = SecurityUtils.getSubject();
        //创建身份密码验证Token
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");


        try {
            //登录
            //subject.login会自动委托给SecurityManager.login方法进行登录
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        //断言已经登录
        Assert.assertEquals(true, subject.isAuthenticated());
        //subject.logout会自动委托给SecurityManager.logout方法退出
        subject.logout();
    }
}
