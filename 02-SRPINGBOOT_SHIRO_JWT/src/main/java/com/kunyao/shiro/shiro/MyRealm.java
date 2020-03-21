package com.kunyao.shiro.shiro;

import cn.hutool.core.util.ObjectUtil;
import com.kunyao.shiro.config.SpringContextBeanService;
import com.kunyao.shiro.constant.PublicConstant;
import com.kunyao.shiro.entity.UsersEntity;
import com.kunyao.shiro.service.PermissionService;
import com.kunyao.shiro.service.RoleService;
import com.kunyao.shiro.service.UserService;
import com.kunyao.shiro.utils.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: MyRealm
 * @Author: kunyao
 * @Description: 自定义Realm
 * @Date: 2019/12/12 15:23
 * @Version: 1.0
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    public MyRealm() {
        this.setCredentialsMatcher(new JwtMatcher());
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if(userService == null){
            this.userService = SpringContextBeanService.getBean(UserService.class);
        }
        if(roleService == null){
            this.roleService = SpringContextBeanService.getBean(RoleService.class);
        }
        if(permissionService == null){
            this.permissionService = SpringContextBeanService.getBean(PermissionService.class);
        }
        //因为自定义了JWTToken，所有pricipal和credentials的值都是token
        String token = (String) principalCollection.getPrimaryPrincipal();

        String userId = JWTUtil.getUserNo(token);
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        roles = roleService.findByUserId(Long.parseLong(userId));
        permissions = permissionService.findByUserId(Long.parseLong(userId));
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        //将角色权限信息返回给Authorizer进行校验
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if(userService == null){
            this.userService = SpringContextBeanService.getBean(UserService.class);
        }

        String token = (String) authenticationToken.getCredentials();

        String userNo = JWTUtil.getUserNo(token);
        if(userNo == null){
            throw new AuthenticationException("token invalid");
        }
        UsersEntity users = null;
        try {
            users = userService.findById(Long.parseLong(userNo));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(ObjectUtil.isEmpty(users)){
            throw new AuthenticationException("User didn't existed!");
        }

        if(!JWTUtil.verify(token, users.getId().toString(), users.getUsername())){
            throw new AuthenticationException(PublicConstant.INVALID_USERNAME_PASSWORD);
        }
        //将登录认证信息返回给Authenticator进行校验
        return new SimpleAuthenticationInfo(token, token, this.getName());
    }
}
