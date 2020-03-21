package com.kunyao.shiro.chapter2_Authentication;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


/**
 * @ClassName: AuthenticatorTest
 * @Author: kunyao
 * @Description: 测试在多Realm情况下Authenticator全部成功的策略
 * @Date: 2020/3/6 10:47
 * @Version: 1.0
 */
public class AuthenticatorTest {

    private void login(String  configFile){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        subject.login(token);
    }

    @Test
    public void testAllSuccessfulStrategyWithSuccess(){
        login("classpath:shiro-authenticator-all-success.ini");
        Subject subject = SecurityUtils.getSubject();
        //得到一个身份集合，其包含了Realm验证成功的信息
        PrincipalCollection principalCollection = subject.getPrincipals(); //此时principalCollection包含 zhang,zhang@163.com
        Assert.assertEquals(2, principalCollection.asList().size());
    }
}
