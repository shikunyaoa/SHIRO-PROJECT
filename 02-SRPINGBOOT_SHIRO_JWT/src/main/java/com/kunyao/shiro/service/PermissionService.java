package com.kunyao.shiro.service;

import java.util.Set;

public interface PermissionService {
    Set<String> findByUserId(long parseLong);
}
