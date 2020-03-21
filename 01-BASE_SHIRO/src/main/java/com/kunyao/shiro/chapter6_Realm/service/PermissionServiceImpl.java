package com.kunyao.shiro.chapter6_Realm.service;


import com.kunyao.shiro.chapter6_Realm.dao.PermissionDao;
import com.kunyao.shiro.chapter6_Realm.dao.PermissionDaoImpl;
import com.kunyao.shiro.chapter6_Realm.entity.Permission;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao = new PermissionDaoImpl();

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
