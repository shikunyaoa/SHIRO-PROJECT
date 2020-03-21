package com.kunyao.shiro.chapter6_Realm.realm;

import com.kunyao.shiro.chapter6_Realm.entity.User;
import com.kunyao.shiro.chapter6_Realm.service.UserService;
import com.kunyao.shiro.chapter6_Realm.service.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName: UserRealm
 * @Author: kunyao
 * @Description: 自定义用户安全数据UserRealm
 * @Date: 2020/3/6 14:03
 * @Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    private UserService userService = new UserServiceImpl();

    //获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(username));
        authorizationInfo.setStringPermissions(userService.findPermissions(username));
        return authorizationInfo;
    }

    //获取身份信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();

        User user = userService.findByUsername(username);

        if(user == null){
            throw new UnknownAccountException(); //没有找到账号
        }
        if(Boolean.TRUE.equals(user.getLocked())){
            throw new LockedAccountException(); //账号被锁定
        }
        //交给AuthenticatingRealm的CredentialMatcher进行密码匹配
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), getName());

        return simpleAuthenticationInfo;
    }
}
