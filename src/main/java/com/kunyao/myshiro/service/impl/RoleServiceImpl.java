package com.kunyao.myshiro.service.impl;

import com.kunyao.myshiro.entity.Role;
import com.kunyao.myshiro.mapper.RoleMapper;
import com.kunyao.myshiro.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色 服务实现类
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
