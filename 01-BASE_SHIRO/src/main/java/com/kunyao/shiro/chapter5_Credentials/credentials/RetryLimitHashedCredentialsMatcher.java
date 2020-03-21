package com.kunyao.shiro.chapter5_Credentials.credentials;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: RetryLimitHashedCredentialsMatcher
 * @Author: kunyao
 * @Description: 重试次数限制匹配
 * @Date: 2020/3/6 13:29
 * @Version: 1.0
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Ehcache passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher() {
        CacheManager cacheManager = CacheManager.newInstance(CacheManager.class.getClassLoader().getResourceAsStream("ehcache.xml"));
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo authenticationInfo) {

        String username = (String) token.getPrincipal();
        Element element = passwordRetryCache.get(username);
        if(element == null){
            element = new Element(username, new AtomicInteger(0));
            passwordRetryCache.put(element);
        }

        AtomicInteger retryCount = (AtomicInteger) element.getObjectValue();
        if(retryCount.incrementAndGet() > 5){
            throw new ExcessiveAttemptsException();
        }
        boolean matches = super.doCredentialsMatch(token, authenticationInfo);
        if(matches){
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
