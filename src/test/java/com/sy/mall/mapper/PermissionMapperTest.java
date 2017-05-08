package com.sy.mall.mapper;

import com.sy.mall.BaseTest;
import com.sy.mall.common.util.JsonUtil;
import com.sy.mall.pojo.Permission;
import com.sy.mall.pojo.Role;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lilei on 2017/5/2.
 */
public class PermissionMapperTest extends BaseTest {
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RoleMapper roleMapper;

    @Test
    public void listByRoleList() {
        Set<Role> roleSet = new HashSet<>();
        roleSet = roleMapper.listByUserId(1L);
        //Set<Permission> permissionSet = permissionMapper.listByRoleList(null);
        Set<Permission> permissionSet = permissionMapper.listByRoleList(new ArrayList<>(roleSet));
        System.out.println(JsonUtil.toJson(permissionSet));
    }
}
