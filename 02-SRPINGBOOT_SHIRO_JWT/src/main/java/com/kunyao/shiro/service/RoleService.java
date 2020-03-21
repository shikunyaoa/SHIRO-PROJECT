package com.kunyao.shiro.service;

import java.util.Set;

/**
 * @ClassName: RoleService
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/21 10:03
 * @Version: 1.0
 */
public interface RoleService {

    Set<String> findByUserId(long parseLong);
}
