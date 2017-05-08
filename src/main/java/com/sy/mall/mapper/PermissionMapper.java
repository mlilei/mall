package com.sy.mall.mapper;

import com.sy.mall.pojo.Permission;
import com.sy.mall.pojo.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Set;

/**
 * Created by 李磊
 * on 2017/3/27.
 */
public interface PermissionMapper extends Mapper<Permission> {

    Set<Permission> listByRoleList(List<Role> roleList);
}
