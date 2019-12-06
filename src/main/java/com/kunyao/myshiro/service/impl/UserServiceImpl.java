package com.kunyao.myshiro.service.impl;

import com.kunyao.myshiro.entity.User;
import com.kunyao.myshiro.mapper.UserMapper;
import com.kunyao.myshiro.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
