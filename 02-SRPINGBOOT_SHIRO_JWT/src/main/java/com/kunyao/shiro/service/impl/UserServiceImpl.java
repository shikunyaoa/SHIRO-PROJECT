package com.kunyao.shiro.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.kunyao.shiro.constant.PublicConstant;
import com.kunyao.shiro.dao.UsersDao;
import com.kunyao.shiro.entity.UsersEntity;
import com.kunyao.shiro.exception.BusinessException;
import com.kunyao.shiro.service.UserService;
import com.kunyao.shiro.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Author: kunyao
 * @Description: 用户认证服务层
 * @Date: 2020/3/20 21:53
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersDao usersDao;


    @Override
    public UsersEntity findById(Long id) throws Exception {
        if(ObjectUtil.isEmpty(id)){
            throw new BusinessException(PublicConstant.INVALID_PARAM);
        }
        UsersEntity usersEntity1 = usersDao.findById(id);
        return usersEntity1;
    }

    @Override
    public UsersEntity login(UsersEntity usersEntity) throws Exception {
        if(ObjectUtil.isEmpty(usersEntity)){
            throw new BusinessException(PublicConstant.INVALID_PARAM);
        }
        UsersEntity usersEntity1 = usersDao.findUser(usersEntity);
        if(ObjectUtil.isEmpty(usersEntity1)){
            throw new BusinessException(PublicConstant.INVALID_USER);
        }
        if(!usersEntity1.getPassword().equals(BCrypt.hashpw(usersEntity.getPassword()))){
            throw new BusinessException(PublicConstant.INVALID_USERNAME_PASSWORD);
        }
        String token = JWTUtil.sign(usersEntity1.getId().toString(), usersEntity1.getUsername());
        usersEntity1.setToken(token);
        return usersEntity1;
    }
}
