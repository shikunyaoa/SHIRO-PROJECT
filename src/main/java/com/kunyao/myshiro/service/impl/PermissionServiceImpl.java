package com.kunyao.myshiro.service.impl;


import com.kunyao.myshiro.entity.Permission;
import com.kunyao.myshiro.mapper.PermissionMapper;
import com.kunyao.myshiro.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统权限 服务实现类
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
