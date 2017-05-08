package com.sy.mall.Service;

import com.sy.mall.mapper.PermissionMapper;
import com.sy.mall.pojo.Permission;

import javax.annotation.Resource;

/**
 * Created by 李磊
 * on 2017/5/3.
 */
public class PermissionService extends BaseService<Permission> {
    @Resource
    private PermissionMapper permissionMapper;

    @Resource(name = "permissionMapper")
    public void setMapper(PermissionMapper permissionMapper) {
        super.setMapper(permissionMapper);
    }

}
