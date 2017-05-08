package com.sy.mall.mapper;

import com.sy.mall.BaseTest;
import com.sy.mall.common.util.JsonUtil;
import com.sy.mall.pojo.Role;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by lilei on 2017/5/2.
 */
public class RoleMapperTest extends BaseTest {
    @Resource
    private RoleMapper roleMapper;

    @Test
    public void selectbyUserId() {
        Set<Role> roles = roleMapper.listByUserId(1L);
        System.out.println(JsonUtil.toJson(roles));
    }
}
