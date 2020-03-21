package com.kunyao.shiro.dao;

import com.kunyao.shiro.entity.UsersEntity;

/**
 * @ClassName: UsersDao
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/20 19:40
 * @Version: 1.0
 */
public interface UsersDao {

    /**
     * 查找用户
     * @param usersEntity
     * @return
     */
    UsersEntity findUser(UsersEntity usersEntity);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    UsersEntity findById(Long id);
}
