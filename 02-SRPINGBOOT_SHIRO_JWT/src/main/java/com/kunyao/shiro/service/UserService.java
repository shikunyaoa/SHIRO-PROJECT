package com.kunyao.shiro.service;


import com.kunyao.shiro.entity.UsersEntity;

/**
 * @author shikunaaa
 */
public interface UserService {




    UsersEntity findById(Long id) throws Exception;

    /**
     * 用户登录
     * @param usersEntity
     * @return
     * @throws Exception
     */
    UsersEntity login(UsersEntity usersEntity) throws Exception;
}
